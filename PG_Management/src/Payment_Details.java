import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Payment_Details extends JFrame {
    JButton back;
    Payment_Details(){
        // frame
        setLayout(null);
        setBounds(400,40,800,800);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(" Room Status ");

        JLabel heading=new JLabel(" Payment Details ");
        heading.setFont(new Font("Engravers MT",Font.BOLD,30));
        heading.setBounds(180,30,700,50);
        add(heading);

        Font font=new Font("Arial",Font.PLAIN,20);


//        bedid
//roomno
//customerid
//bedstatus
        JLabel bedid=new JLabel("Payment Status");
        bedid.setBounds(50,120,150,20);
        add(bedid);
        bedid.setFont(font);

        JLabel roomno=new JLabel("Deposite ");
        roomno.setBounds(210,120,100,20);
        add(roomno);
        roomno.setFont(font);

        JLabel customerid=new JLabel("Monthly Rent");
        customerid.setBounds(330,120,150,20);
        add(customerid);
        customerid.setFont(font);

        JLabel bedstatus=new JLabel("Customer ID ");
        bedstatus.setBounds(480,120,150,20);
        add(bedstatus);
        bedstatus.setFont(font);

        JLabel paymentmethod=new JLabel("Payment Method");
        paymentmethod.setBounds(610,120,200,20);
        add(paymentmethod);
        paymentmethod.setFont(font);

        JTable table=new JTable();
        table.setBounds(50,150,700,400);
        add(table);
        table.setFont(font);

        back=new JButton("BACK");
        back.setFont(font);
        back.setBounds(300,600,150,40);
        add(back);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        try {
            Java_Con conn=new Java_Con();
            conn.createCon();
            ResultSet rs=conn.stmt.executeQuery("select * from paymentdetail");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            System.out.println(e);
        }

        setUndecorated(true);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Payment_Details();
    }
}
