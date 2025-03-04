import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Update_customer_Details extends JFrame implements ActionListener {
    JComboBox comUpdate;
    JLabel l1,l2;
    JButton search,update,back;
    String customerId;
    JTextField Updatefield;
    Choice room,bedid;
    Update_customer_Details(String custid){
        this.customerId=custid;

        setLayout(null);
        setBounds(400, 40, 800, 800);
        setTitle("Update Customer ");

        JLabel heading = new JLabel("UPDATE CUSTOMER");
        heading.setFont(new Font("Engravers MT", Font.BOLD, 30));
        heading.setBounds(150, 30, 500, 50);
        add(heading);

        Font font=new Font("Arial",Font.PLAIN,20);

        JLabel updateLabel = new JLabel(" What do you want to update  ");
        updateLabel.setBounds(50, 100, 350, 30);
        updateLabel.setFont(font);
        add(updateLabel);

//        ,"Change BED"
        String updateList[]={"Update Name","Update Mobile NO","Change Room"};
        comUpdate = new JComboBox(updateList);
        comUpdate.setBounds(400, 100, 200, 30);
        comUpdate.setFont(font);
        add(comUpdate);
//        comUpdate.addActionListener(this);

        search=new JButton("Search");
        search.setBounds(620,100,150,30);
        add(search);
        search.addActionListener(this);

        l1=new JLabel("");
        l1.setBounds(50,150,500,40);
        add(l1);
        l1.setFont(font);

        l2=new JLabel();
        l2.setBounds(50,210,350,40);
        add(l2);
        l2.setFont(font);

        Updatefield=new JTextField();
        Updatefield.setBounds(420,210,200,40);
        add(Updatefield);
        Updatefield.setFont(font);
        Updatefield.setVisible(false);

        room=new Choice();
        room.setBounds(420,210,100,40);
        add(room);
        room.setFont(font);
        room.setVisible(false);

        bedid=new Choice();
        bedid.setBounds(540,210,150,40);
        add(bedid);
        bedid.setFont(font);
        bedid.setVisible(false);

//        update=new JButton("UPDATE");
//        update.setBounds(270,400,100,30);
//        add(update);
//        update.addActionListener(this);
//        update.setBackground(Color.black);
//        update.setForeground(Color.white);

        back=new JButton("BACK");
        back.setBounds(390,400,100,30);
        add(back);
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        aadhar_pan_validation id_valid = new aadhar_pan_validation();

        if(e.getSource()==search){
            Updatefield.setVisible(false);
            // here field is a item in combobox which  user can choose and update according to it
            String field=comUpdate.getSelectedItem().toString();

            if(field.equals("Update Name")){
                search.setText("UPDATE");
                try {
                    Java_Con con=new Java_Con();
                    con.createCon();
                    ResultSet rs=con.stmt.executeQuery("select *from customer where customerid='"+customerId+"';");
                    while (rs.next()){
                        l1.setText("Old Name : "+rs.getString("name"));
                    }
                    l2.setText("Enter new Name : ");
                    Updatefield.setVisible(true);
                    String name=Updatefield.getText();
                    if(name.equals("")){
                        //JOptionPane.showMessageDialog(this,"Please enter name");
                    }
                    else if (!id_valid.isValidName(name)) {
                        JOptionPane.showMessageDialog(null, "Name is NOT Valid !! Pleasse Enter Valid Name");
                    }
                    else {
                        con.stmt.executeUpdate("update customer set name='"+name+"' where customerid='"+customerId+"';");
                        JOptionPane.showMessageDialog(this,"Name updated successfully");
                        setVisible(false);
                    }

                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }

            else if(field.equals("Update Mobile NO")){
                search.setText("UPDATE");
                try {
                    Java_Con con=new Java_Con();
                    con.createCon();
                    ResultSet rs=con.stmt.executeQuery("select *from customer where customerid='"+customerId+"';");
                    while (rs.next()){
                        l1.setText("Old Mobile No : "+rs.getString("mobileno"));
                    }
                    l2.setText("Enter the new Mobile No : ");
                    Updatefield.setVisible(true);
                    String mobileNo=Updatefield.getText();

                    if(mobileNo.equals("")){
                       // JOptionPane.showMessageDialog(this,"Field is Manadatory ");
                    }
                   else if (!id_valid.isValidMobileNumber(mobileNo)) {
                        JOptionPane.showMessageDialog(null, "Please Enter Correct Mobile Number \n Only numbers allowed");
                    }
                   else {
                        con.stmt.executeUpdate("update customer set mobileno='"+mobileNo+"' where customerid='"+customerId+"';");
                         JOptionPane.showMessageDialog(this,"Mobile No updated successfully ");
                         setVisible(false);
                    }
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }

            // update room and bed *********

            else if(field.equals("Change Room")){
                search.setText("UPDATE");
                try {
                   String oldRoom="";
                   String oldBedId="";
                    Java_Con con=new Java_Con();
                    con.createCon();
                   ResultSet rs= con.stmt.executeQuery("select * from bed where customerid='"+customerId+"';");
                    while (rs.next()){
                        oldRoom=rs.getString("roomno");
                        oldBedId=rs.getString("bedid");
                    }
                    l1.setText("Your old room No : "+oldRoom+" and BED ID : "+oldBedId);

//                    Updatefield.setVisible(true);
                    l2.setText("Choose new Room and Bed ");

                    // it retrive the room from table
                    ResultSet rs1=con.stmt.executeQuery("select * from room where status='Available';");
                   room.setVisible(true);
                   bedid.setVisible(true);
                    while (rs1.next()){
                        room.add(rs1.getString("roomno"));
//                        bedid.add(rs1.getString("bedid"));
                    }
//                    String roomno=room.getSelectedItem();

                    room.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
if(e.getStateChange()==1){
    String roomno=room.getSelectedItem();

    try{
        bedid.removeAll();
        ResultSet bedRS=con.stmt.executeQuery("select *from beddetail where bedstatus='Available' and roomno='"+roomno+"';");
        while (bedRS.next()){
            bedid.add(bedRS.getString("bedid"));
        }
    }catch (Exception exception){
        System.out.println(exception);
    }
}
                        }
                    });

                    // it need to be executed after checking all the above conditions
//
                    String bedID= bedid.getSelectedItem();
                    if(bedID.equals("") || room.getSelectedItem().equals("")){
                        JOptionPane.showMessageDialog(this,"Please choose roomno and bed id  ");
                    }else {
                        con.stmt.executeUpdate("update beddetail set bedstatus='Available' where bedid='"+oldBedId+"';");
                        con.stmt.executeUpdate("update beddetail set bedstatus='occupied' where bedid='"+bedID+"';");
                        con.stmt.executeUpdate("update bed set bedid='"+bedID+"', roomno='"+room.getSelectedItem()+"' where customerid='"+customerId+"';");
                        con.stmt.executeUpdate("update customerroomdetail set roomno='"+room.getSelectedItem()+"',bedid='"+bedID+"';");
                        JOptionPane.showMessageDialog(this,"Update room successfully  ");
                        setVisible(false);
                    }


                    //************************
                    // this is running
                    //
                }
                catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }

            else if(field.equals("Change BED")){
                JOptionPane.showMessageDialog(this,"Update bed  called ");
            }


        }

//        else if(e.getSource()==update){
//
//            try {
//                Java_Con con =new Java_Con();
//                con.createCon();
////                con.stmt.executeUpdate("")
//            }catch (Exception exception){
//                System.out.println(exception.getMessage());
//            }
//        }
        else if(e.getSource()==back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Update_customer_Details("856932415698");
    }
}
