import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login_Page extends JFrame implements ActionListener {
    JButton submit,clear;
    JPasswordField passwordField;
    JTextField nameField;
  Login_Page(){
      setVisible(true);
      setLayout(null);
      setBounds(400,100,800,400);
      setTitle("Login Page");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JLabel heading=new JLabel("ADMIN LOGIN");
      heading.setFont(new Font("Arial",Font.BOLD,30));
      heading.setForeground(Color.red);
      heading.setBounds(250,10,500,40);
      add(heading);


      ImageIcon icon=new ImageIcon("images/admin_icon.jpg");
      Image image=icon.getImage();
      Image im=image.getScaledInstance(300,300,Image.SCALE_SMOOTH);
      icon=new ImageIcon(im);
      JLabel label=new JLabel(icon,JLabel.RIGHT);
      label.setBounds(450,50,300,300);
    add(label);


      JLabel uname=new JLabel("User Name :");
      uname.setFont(new Font("Arial", Font.BOLD,20));
      uname.setBounds(50,80,200,40);
      add(uname);
       nameField=new JTextField();
      nameField.setBounds(250,80,150,40);
      add(nameField);

      JLabel passwd=new JLabel("Enter Password :");
      passwd.setBounds(50,150,200,40);
      passwd.setFont(new Font("Arial", Font.BOLD,20));
     add(passwd);

       passwordField=new JPasswordField();
      passwordField.setBounds(250,150,150,40);
      add(passwordField);

      submit=new JButton("SUBMIT");
      submit.setBounds(120,220,100,40);
      submit.setForeground(Color.WHITE);
      submit.setBackground(Color.black);
      submit.addActionListener(this);
      add(submit);

      clear=new JButton("CLEAR");
      clear.setBounds(250,220,100,40);
      clear.setForeground(Color.WHITE);
      clear.setBackground(Color.black);
      clear.addActionListener(this);
      add(clear);
  }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==clear){
            nameField.setText("");
            passwordField.setText("");
        }
        else if(ae.getSource()==submit){
            try {
                Java_Con con=new Java_Con();
                con.createCon();
                ResultSet rs=con.stmt.executeQuery("select *from login");
                String username="";
                String passwd="";

                while (rs.next()){
                     username=rs.getString(1);
                     passwd=rs.getString(2);
                }

//                 get data from table and check ;

                if(nameField.getText().equals(username) && passwordField.getText().equals(passwd)){
                    JOptionPane.showMessageDialog(this,"Successfully LOGIN ");
                    new Home_page();
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(this,"Login Failed \n Invalid Username or Password");
                }

            }
            catch (Exception e){
                System.out.println(e);
            }

        }
    }

    public static void main(String[] args) {
       new Login_Page();
    }


}
