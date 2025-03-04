import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class RoomStatus extends JFrame {
    RoomStatus(){
        // frame
        setLayout(null);
        setBounds(400,40,800,800);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(" Room Status ");

        JLabel heading=new JLabel(" Check Bed Status");
        heading.setFont(new Font("Engravers MT",Font.BOLD,30));
        heading.setBounds(180,30,700,50);
        add(heading);

//     adding images to the frame
//        JPanel panel=new JPanel();
//        panel.setBounds(500,100,300,500);
//        panel.setBackground(new Color(255, 255, 255, 0));
//        panel.setLayout(null);
//        add(panel);
//
//        ImageIcon icon=new ImageIcon("images/Room_4_sharing.jpeg");
//        Image image=icon.getImage();
//        Image newImage=image.getScaledInstance(300,400,Image.SCALE_SMOOTH);
//        icon=new ImageIcon(newImage);
//        JLabel l1=new JLabel("",icon,JLabel.CENTER);
//        l1.setBounds(0,0,300,400);
//        panel.add(l1);

        Font font=new Font("Arial",Font.PLAIN,20);


//        bedid
//roomno
//customerid
//bedstatus
        JLabel bedid=new JLabel("Bed ID");
        bedid.setBounds(90,120,100,20);
        add(bedid);
        bedid.setFont(font);

        JLabel roomno=new JLabel("Room NO ");
        roomno.setBounds(250,120,100,20);
        add(roomno);
        roomno.setFont(font);

        JLabel customerid=new JLabel("Customer ID");
        customerid.setBounds(410,120,150,20);
        add(customerid);
        customerid.setFont(font);

        JLabel bedstatus=new JLabel("Bed Status");
        bedstatus.setBounds(580,120,200,20);
        add(bedstatus);
        bedstatus.setFont(font);




        JTable table=new JTable();
        table.setBounds(50,150,700,400);
        add(table);
        table.setFont(font);


        try {
            Java_Con conn=new Java_Con();
            conn.createCon();
            ResultSet rs=conn.stmt.executeQuery("select * from bed");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            System.out.println(e);
        }


        setUndecorated(true);
        setVisible(true);
    }


    public static void main(String[] args) {
        new RoomStatus();
    }
}
