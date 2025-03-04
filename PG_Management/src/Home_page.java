import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home_page extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,searchRoom,searchCustomer;
// search by room
//    search by customer id or name;
    Home_page(){
        setLayout(null);
//        setVisible(true);
        setBounds(0,0,1600,850);
        setTitle("HOME PAGE ");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

ImageIcon icon=new ImageIcon("images/PG_boys.jpg");
Image image=icon.getImage();
Image newImage=image.getScaledInstance(1600,850,Image.SCALE_SMOOTH);
icon=new ImageIcon(newImage);
JLabel l1=new JLabel("",icon,JLabel.CENTER);
l1.setBounds(0,0,1600,850);
add(l1);

ImageIcon boysicon=new ImageIcon("images/The_boys_2.jpg");
Image image2=boysicon.getImage();
Image newImage2=image2.getScaledInstance(200,200,Image.SCALE_SMOOTH);
boysicon=new ImageIcon(newImage2);
JLabel boysimg=new JLabel("",boysicon,JLabel.CENTER);
 boysimg.setBounds(1300,0,200,200);
l1.add(boysimg);


JPanel panel=new JPanel();
panel.setBounds(100,100,200,600);
panel.setBackground(new Color(255, 255, 255, 0));
panel.setLayout(null);
l1.add(panel);

        b1=new JButton();
        b1.setText("Add Customer");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        b1.setBounds(10,10,150,40);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton();
        b2.setText("Manage Customer ");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        b2.setBounds(10,70,150,40);
        b2.addActionListener(this);
        panel.add(b2);

        b3=new JButton();
        b3.setText("Payment Details");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.black);
        b3.setBounds(10,130,150,40);
        b3.addActionListener(this);
        panel.add(b3);

        b4=new JButton();
        b4.setText("Add Room");
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.black);
        b4.setBounds(10,190,150,40);
        b4.addActionListener(this);
        panel.add(b4);

        searchRoom=new JButton();
        searchRoom.setText("Search Room");
        searchRoom.setForeground(Color.WHITE);
        searchRoom.setBackground(Color.black);
        searchRoom.setBounds(10,250,150,40);
        searchRoom.addActionListener(this);
        panel.add(searchRoom);

        searchCustomer=new JButton();
        searchCustomer.setText("Search Customer");
        searchCustomer.setForeground(Color.WHITE);
        searchCustomer.setBackground(Color.black);
        searchCustomer.setBounds(10,310,150,40);
        searchCustomer.addActionListener(this);
        panel.add(searchCustomer);

        b5=new JButton();
        b5.setText("Logout");
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.black);
        b5.setBounds(10,370,150,40);
        b5.addActionListener(this);
        panel.add(b5);

        setUndecorated(true);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
                new Add_Customer();
        }
        else if(ae.getSource()==b2){
            new Manage_customer();

        }else if(ae.getSource()==b3){
            new Payment_Details();

        }else if(ae.getSource()==b4){
            new Add_Room();

        }else if(ae.getSource()==b5){
            JOptionPane.showMessageDialog(this,"Logout successfully ");
            System.exit(0);
        }
        else if(ae.getSource()==searchRoom){
            new Search_Room_Bed();
        }
        else if(ae.getSource()==searchCustomer){
            new Manage_customer();
        }

    }

    public static void main(String[] args) {
        new Home_page();
    }

}
