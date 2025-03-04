import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_Room_Bed extends JFrame implements ActionListener {
    JButton search,back,update;
    Choice searchBox;
    JTable table,Bedtable;
    JCheckBox check;
    Search_Room_Bed(){
// frame
        setLayout(null);
        setBounds(400,40,800,800);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(" Search Room  ");

        JLabel heading=new JLabel(" Search Room ");
        heading.setFont(new Font("Engravers MT",Font.BOLD,30));
        heading.setBounds(200,20,700,50);
        add(heading);

        Font font=new Font("Arial",Font.PLAIN,20);

        JLabel searchLabel=new JLabel("Search By Room NO : ");
        searchLabel.setFont(font);
        searchLabel.setBounds(50,85,220,40);
        add(searchLabel);

        searchBox=new Choice();
        searchBox.setFont(font);
        searchBox.setBounds(270,90,150,40);
        add(searchBox);
        searchBox.getSelectedItem();
        try {
            Java_Con con=new Java_Con();
            con.createCon();

            ResultSet rs=con.stmt.executeQuery("select *from room;");
            while (rs.next()){
                searchBox.add(rs.getString("roomno"));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this,"Can not connect to the database\n"+e.getMessage());
        }

        search=new JButton("SEARCH");
        search.setFont(font);
        search.setBounds(440,90,120,30);
        add(search);
        search.setForeground(Color.white);
        search.setBackground(Color.black);
        search.addActionListener(this);



        back=new JButton("BACK");
        back.setFont(font);
        back.setBounds(580,90,120,30);
        add(back);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);



//        bedid
//roomno
//customerid
//bedstatus
        JLabel roomno=new JLabel("Room NO");
        roomno.setBounds(90,140,100,20);
        add(roomno);
        roomno.setFont(font);

        JLabel capacity=new JLabel("Capacity ");
        capacity.setBounds(250,140,100,20);
        add(capacity);
        capacity.setFont(font);

        JLabel status=new JLabel("Status");
        status.setBounds(410,140,150,20);
        add(status);
        status.setFont(font);

        JLabel bedid=new JLabel("Bed ID's");
        bedid.setBounds(580,140,200,20);
        add(bedid);
        bedid.setFont(font);

    JPanel panel=new JPanel();
    panel.setLayout(null);
    panel.setBounds(50,170,700,200);
    add(panel);

         table=new JTable();
        table.setBounds(0,0,700,200);
        panel.add(table);
        table.setFont(font);

        try {
            Java_Con conn=new Java_Con();
            conn.createCon();
            ResultSet rs=conn.stmt.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }

        check=new JCheckBox("Search bed according to room no");
        check.setBounds(50,400,400,30);
        check.setFont(font);
        add(check);
        check.addActionListener(this);

        update=new JButton("Update");
        update.setFont(font);
        update.setBounds(480,400,200,30);
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.addActionListener(this);
        add(update);


        // bed info

    JPanel bedpanel=new JPanel();
    bedpanel.setLayout(null);
    bedpanel.setBounds(50,460,700,300);
    add(bedpanel);


        JLabel bedid_label=new JLabel("Room NO");
        bedid_label.setBounds(30,0,100,20);
        bedpanel.add(bedid_label);
        bedid_label.setFont(font);

        JLabel roomnoLabel=new JLabel("Bed Id ");
        roomnoLabel.setBounds(260,0,100,20);
        bedpanel.add(roomnoLabel);
        roomnoLabel.setFont(font);

//        JLabel customerid=new JLabel("Customer ID");
//        customerid.setBounds(390,70,150,20);
//        bedpanel.add(customerid);
//        customerid.setFont(font);

        JLabel bedstatus=new JLabel("Bed Status");
        bedstatus.setBounds(490,0,200,20);
        bedpanel.add(bedstatus);
        bedstatus.setFont(font);

         Bedtable=new JTable();
        Bedtable.setBounds(0,30,700,300);
        bedpanel.add(Bedtable);
        Bedtable.setFont(font);
        Bedtable.setVisible(false);


        try {
            Java_Con conn=new Java_Con();
            conn.createCon();
            ResultSet rs=conn.stmt.executeQuery("select * from beddetail");
            Bedtable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }
        setUndecorated(true);
        setVisible(true);
    }

    // action perfromed
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==search) {
            String getroomno = searchBox.getSelectedItem();
            try {
                Java_Con con = new Java_Con();
                con.createCon();
                ResultSet rs = con.stmt.executeQuery("select *from room where roomno='" + getroomno + "';");
                table.removeAll();
                table.setModel(DbUtils.resultSetToTableModel(rs));
                String roomno=searchBox.getSelectedItem();
               ResultSet rs2=con.stmt.executeQuery("select *from beddetail where roomno='"+roomno+"';");
                Bedtable.removeAll();
                Bedtable.setModel(DbUtils.resultSetToTableModel(rs2));
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "error\n" + e.getMessage());
            }
        }
        else if(ae.getSource()==check){
            if(check.isSelected())
                Bedtable.setVisible(true);
            else
                Bedtable.setVisible(false);
        }
        else if(ae.getSource()==back){
            setVisible(false);
        }
        else if(ae.getSource()==update){
            int res=JOptionPane.showConfirmDialog(this,"Change room status\n Available to Occupied ");
            if(res==0){
                System.out.println("True");
                try {
                    String roomno=searchBox.getSelectedItem();
                    String roomStatus=null;
                    Java_Con con=new Java_Con();
                    con.createCon();
                    ResultSet rs=con.stmt.executeQuery("select status from room where roomno='"+roomno+"';");
                    while (rs.next()){
                        roomStatus=rs.getString("status");
                    }
                    if(roomStatus.equals("Available")){
                        con.stmt.executeUpdate("update room set status='Occupied' where roomno='"+roomno+"';");
                        JOptionPane.showMessageDialog(this,"Room 'Occupied' Status updated");
                    }
                    else if(roomStatus.equals("Occupied")){
                        con.stmt.executeUpdate("update room set status='Available' where roomno='"+roomno+"';");
                        JOptionPane.showMessageDialog(this,"Room 'Available' Status updated");
                    }

                }catch (Exception e){
                    JOptionPane.showMessageDialog(this,"Error in Updating the Status\n"+e.getMessage());
                }
            }
            else if(res==1) {
                System.out.println("False");
            }
        }

    }


    public static void main(String[] args) {
        new Search_Room_Bed();
    }


}
