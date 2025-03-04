import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_Customer extends JFrame implements ActionListener {
    Choice searchBox;
    JTable table;
    JCheckBox check;

    Search_Customer(){
        setLayout(null);
        setBounds(400,40,800,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Search Customer ");

        JLabel heading=new JLabel("Search CUSTOMER");
        heading.setFont(new Font("Engravers MT",Font.BOLD,30));
        heading.setBounds(230,30,400,50);
        add(heading);

        // adding images to the frame
//        JPanel panel=new JPanel();
//        panel.setBounds(500,100,300,500);
//        panel.setBackground(new Color(255, 255, 255, 50));
//        panel.setLayout(null);
//        add(panel);
//
//        ImageIcon icon=new ImageIcon("images/search_cut1.png");
//        Image image=icon.getImage();
//        Image newImage=image.getScaledInstance(300,600,Image.SCALE_SMOOTH);
//        icon=new ImageIcon(newImage);
//        JLabel l1=new JLabel("",icon,JLabel.CENTER);
//        l1.setBounds(0,0,300,600);
//        panel.add(l1);

//        Actual Code

        Font font=new Font("Arial",Font.PLAIN,20);

        JLabel searchLabel=new JLabel("Search using Customer ID : ");
        searchLabel.setFont(font);
        searchLabel.setBounds(50,85,300,40);
        add(searchLabel);

        searchBox=new Choice();
        searchBox.setFont(font);
        searchBox.setBounds(320,90,150,40);
        add(searchBox);



//        JTextField nameField=new JTextField();

/*
customerid
name
gender
doctype
dateofjoin
mobileno
address
roomtype
facility
additionalfacility
 */

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,170,800,200);
        add(panel);

        JLabel id=new JLabel("Customer ID ");
        id.setBounds(10,0,150,20);
        id.setFont(font);
        panel.add(id);

        JLabel name=new JLabel("Name");
        name.setFont(font);
        name.setBounds(170,0,150,20);
        add(name);





        table=new JTable();
        table.setBounds(0,40,800,200);
        panel.add(table);
        table.setFont(font);

        try {
            Java_Con conn=new Java_Con();
            conn.createCon();
            ResultSet rs=conn.stmt.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }

        check=new JCheckBox("Search bed according to room no");
        check.setBounds(50,400,400,30);
        check.setFont(font);
        add(check);
        check.addActionListener(this);




    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }




    public static void main(String[] args) {
        new Search_Customer();
    }
}
