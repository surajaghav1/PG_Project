import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.StringTokenizer;
//WindoListener   ==>> not working

public class Room extends JFrame implements ActionListener{


    int TotalPayableAmount=0,depositeAmount=3000,monthlyRent=0;
    String paymentmethod=null;
    Choice availRoom,availBed;
    int roomtype_sharing=0;
    JButton submit,back,payment,showTermsCondi;
JLabel TotalPayableAmountLabel,paymentOption;
    JCheckBox termsCondition;
    JRadioButton online,cash;
    String customerid="";  // this is for storing the customer id


Room(String roomtype,int monthRent,String custid){
    this.monthlyRent=monthRent;
    this.roomtype_sharing= Integer.parseInt(String.valueOf(roomtype.charAt(0)));
    this.customerid=custid;

    // frame
    setLayout(null);
    setBounds(400,40,800,800);
//    setVisible(true);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Allocating Room ");

    JLabel heading=new JLabel("Allocate Room To Customer");
    heading.setFont(new Font("Engravers MT",Font.BOLD,30));
    heading.setBounds(50,30,700,50);
    add(heading);

//     adding images to the frame
    JPanel panel=new JPanel();
    panel.setBounds(500,100,300,500);
    panel.setBackground(new Color(255, 255, 255, 50));
    panel.setLayout(null);
    add(panel);

    ImageIcon icon=new ImageIcon("images/Room_1.jpeg");
    Image image=icon.getImage();
    Image newImage=image.getScaledInstance(300,400,Image.SCALE_SMOOTH);
    icon=new ImageIcon(newImage);
    JLabel l1=new JLabel("",icon,JLabel.CENTER);
    l1.setBounds(0,0,300,400);
    panel.add(l1);

// Actual code for allocating the room to customer

    Font font=new Font("Arial",Font.PLAIN,20);

    JLabel availabelRoom=new JLabel("Available Rooms");
    availabelRoom.setBounds(50,100,200,40);
    availabelRoom.setFont(font);
    add(availabelRoom);


    availRoom=new Choice();
    availRoom.setBounds(280,100,200,40);
    availRoom.setFont(font);
    add(availRoom);
    availRoom.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            availBed.removeAll();
            System.out.println(e.getItem());
            try {
                Java_Con con=new Java_Con();
                con.createCon();
                String roomnofield=availRoom.getSelectedItem();

                // NOT IN USE =...>> *********

//                String str="";
//                ResultSet rs=con.stmt.executeQuery("select *from room where status='Available' and roomno='"+roomnofield+"';");
//                while (rs.next()){
//                    str+=rs.getString("bedid");
//                }
//                StringTokenizer stringtoken=new StringTokenizer(str,",");
//
////                con.stmt.executeQuery("select * from bed where ")
//                while (stringtoken.hasMoreTokens()){
//                    availBed.add(stringtoken.nextToken());
//                }


                ResultSet rs2=con.stmt.executeQuery("select *from beddetail where roomno='"+roomnofield+"'and bedstatus='Available';");
                while (rs2.next()){
                    availBed.add(rs2.getString("bedid"));
                }

            }
            catch (Exception exception){
                System.out.println(exception);
            }
        }
    });


    try {
        Java_Con con=new Java_Con();
        con.createCon();
        ResultSet rs=con.stmt.executeQuery("select * from room where status='Available' and capacity='"+roomtype_sharing+"';");
       int i=1;
        while (rs.next()){
           availRoom.add(rs.getString("roomno"));
        }
    }catch (Exception e){
        System.out.println(e);
    }



    String romno=availRoom.getSelectedItem();

    JLabel doctype=new JLabel("Available Bed ");
    doctype.setFont(font);
    doctype.setBounds(50,160,200,40);
    add(doctype);

    availBed=new Choice();
    availBed.setBounds(280,160,200,40);
    availBed.setBackground(Color.white);
    availBed.setFont(font);
    add(availBed);

    try {
        Java_Con con=new Java_Con();
        con.createCon();
        ResultSet rs=con.stmt.executeQuery("select * from beddetail where roomno='"+romno+"';");
        int i=1;
        while (rs.next()){
            availBed.add(rs.getString("bedid"));
        }
    }catch (Exception e){
        System.out.println(e);
    }



    JLabel deposite_Label=new JLabel("The Deposit Amount RS."+ depositeAmount);
    deposite_Label.setFont(font);
    deposite_Label.setBounds(50,220,300,40);
    add(deposite_Label);

    termsCondition=new JCheckBox("After clicking this you are accepting all Terms and Conditions",false);
    termsCondition.setFont(new Font("Arial",Font.PLAIN,16));
    termsCondition.setBounds(10,270,480,40);
    add(termsCondition);

    showTermsCondi =new JButton("Terms and Conditions");
    showTermsCondi.setBounds(50,320,250,30);
    showTermsCondi.setFont(font);
    add(showTermsCondi);
    showTermsCondi.setForeground(Color.white);
    showTermsCondi.setBackground(Color.black);
    showTermsCondi.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Show_Rules();
        }
    });


    TotalPayableAmountLabel=new JLabel("The Monthly rent amount  : "+monthlyRent);
    TotalPayableAmountLabel.setBounds(50,370,400,40);
    TotalPayableAmountLabel.setFont(font);
    add(TotalPayableAmountLabel);

    TotalPayableAmount+=monthlyRent+depositeAmount;
    JLabel totalamtLabel=new JLabel("Total Payable Amount : "+TotalPayableAmount);
    totalamtLabel.setFont(font);
    totalamtLabel.setBounds(50,420,300,40);
    add(totalamtLabel);


     paymentOption=new JLabel("Please select payment option");
     paymentOption.setFont(font);
     paymentOption.setBounds(50,470,400,40);
     add(paymentOption);

    online=new JRadioButton("PhonePe/Gpay/UPI Payment");
    online.setFont(font);
    online.setBounds(40,520,320,40);
    add(online);

//    online.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JOptionPane.showMessageDialog(null,new ShowQRcode());
//        }
//    });

    cash=new JRadioButton("Cash");
    cash.setFont(font);
    cash.setBounds(370,520,100,40);
    add(cash);

    ButtonGroup bg=new ButtonGroup();
    bg.add(online);
    bg.add(cash);

    submit=new JButton("SUBMIT");
    submit.setFont(font);
    submit.setBounds(100,600,150,40);
    add(submit);
    submit.setForeground(Color.white);
    submit.setBackground(Color.black);
    submit.setEnabled(false);
    submit.addActionListener(this);

    back=new JButton("BACK");
    back.setFont(font);
    back.setBounds(270,600,150,40);
    add(back);
    back.setForeground(Color.white);
    back.setBackground(Color.black);
    back.addActionListener(this);

    payment=new JButton("Payment");
    payment.setFont(font);
    payment.setBounds(440,600,150,40);
    add(payment);
    payment.setForeground(Color.white);
    payment.setBackground(Color.black);
    payment.addActionListener(this);


    setUndecorated(true);
    setVisible(true);
}



// ACtion Code for Buttons

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            new Add_Customer();
        }
        else if(ae.getSource()==payment){
            if(cash.isSelected()){
                JOptionPane.showMessageDialog(this,"Payable amount : RS."+TotalPayableAmount);
                submit.setEnabled(true);
                paymentmethod="cash";
            }
            else if(online.isSelected()){
//                JOptionPane.showMessageDialog(this,);
               int res= JOptionPane.showConfirmDialog(this,"Payable amount : RS."+TotalPayableAmount);
                // 0=yes, 1=no, 2=cancel
                if(res==0){
                    new ShowQRcode();
                    submit.setEnabled(true);
                    paymentmethod="online";
                }
            }
        }

        else if(ae.getSource()==submit){
        try {
//            	customerid	roomno	bedid	deposite	monthlyrent	totalamount	paymentstatus

                String roomno=availRoom.getSelectedItem().toString();
                String bedid=availBed.getSelectedItem().toString();
                String depositeamt= String.valueOf(depositeAmount);
                String monthrent=String.valueOf(monthlyRent);
                String total=String.valueOf(TotalPayableAmount);
                String paystatus="paid";

                Java_Con con=new Java_Con();
                con.createCon();
                String query="insert into customerroomdetail values('"+customerid+"','"+roomno+"','"+bedid+"','"+depositeamt+"','"+monthrent+"','"+total+"','"+paystatus+"');";
                con.stmt.executeUpdate(query);
                String bedstatus="occupied";
                String query2="insert into bed values('"+bedid+"','"+roomno+"','"+customerid+"','"+bedstatus+"');";
                con.stmt.executeUpdate(query2);

           // Update the bed available status =>> Occupied
//                String query="";
                con.stmt.executeUpdate("update beddetail set bedstatus='"+bedstatus+"' where roomno='"+roomno+"'and bedid='"+bedid+"';");
                JOptionPane.showMessageDialog(this,"bed detail updated");

                // getting the capacity of that table
//                ResultSet rs2=con.stmt.executeQuery("select capacity from room where roomno='"+roomno+"';");
//                String cap=rs2.getString("capacity");
//                int c=Integer.parseInt(cap);
//                c=c-1;
//                con.stmt.executeUpdate("UPDATE room SET capacity='"+c+"' WHERE roomno ='"+roomno+"';");

                con.stmt.executeUpdate("insert into paymentdetail values('"+paystatus+"','"+depositeamt+"','"+monthrent+"','"+customerid+"','"+paymentmethod+"');");
                JOptionPane.showMessageDialog(this,"Data inserted : \n Room allocated to user");
                this.setVisible(false);

        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this,"Error occured in connection\n"+e.getMessage());
        }

        }
//        else if(ae.getSource()==availBed){
//
//        }
//      else if(ae.getSource()==availRoom){       // test it not working
//            String ag[]={"abc","jd"};
//            availRoom=new JComboBox(ag);
//        }

    }


    public static void main(String[] args) {
        new Room("2 sharing",10000,"7463528294");
    }

}
