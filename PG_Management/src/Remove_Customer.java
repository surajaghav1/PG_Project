import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

public class Remove_Customer extends JFrame implements ActionListener {

    // This is for searching the customer

    JTextField customerid;
    JTextField Custname;
    JTextField gender;
    JTextField dateofjoin;
    JTextField mobileno;
    JTextField address;
    JTextField roomno,bedid,paymentDetail,totalAmt;
    JButton submit;
    Choice searchCustomer;

    Remove_Customer() {
        setLayout(null);
        setBounds(400, 40, 800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Search Customer ");

        ImageIcon icon=new ImageIcon("images/search_cut1.png");
        Image image=icon.getImage();
        Image newImage=image.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        icon=new ImageIcon(newImage);
        JLabel l1=new JLabel("",icon,JLabel.CENTER);
        l1.setBounds(600,0,150,100);
        add(l1);

        JLabel heading = new JLabel("SEARCH CUSTOMER");
        heading.setFont(new Font("Engravers MT", Font.BOLD, 30));
        heading.setBounds(150, 30, 500, 50);
        add(heading);

        Font font=new Font("Arial",Font.PLAIN,20);

        JLabel name = new JLabel(" Name ");
        name.setBounds(50, 100, 200, 30);
        name.setFont(font);
        add(name);

        Custname = new JTextField();
        Custname.setBounds(280, 100, 200, 30);
        Custname.setFont(font);
        add(Custname);

        JLabel customerIDLabel=new JLabel("Search Using Customer ID");
        customerIDLabel.setFont(font);
        customerIDLabel.setBounds(500,100,250,30);
        add(customerIDLabel);

        searchCustomer=new Choice();
        searchCustomer.setBounds(500,140,200,30);
        add(searchCustomer);
        searchCustomer.setFont(font);
        try {
            Java_Con con=new Java_Con();
            con.createCon();
            ResultSet rs=con.stmt.executeQuery("select * from customer");
            while (rs.next()){
                searchCustomer.add(rs.getString("customerid"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        JLabel genderlabel = new JLabel(" Gender ");
        genderlabel.setFont(font);
        genderlabel.setBounds(50, 150, 200, 30);
        add(genderlabel);

        gender = new JTextField();
        gender.setBounds(280, 150, 200, 30);
        gender.setFont(font);
        add(gender);

        JLabel doctype = new JLabel("Document NO");
        doctype.setFont(font);
        doctype.setBounds(50, 200, 200, 30);
        add(doctype);

        customerid = new JTextField();
        customerid.setBounds(280, 200, 200, 30);
        customerid.setFont(font);
        add(customerid);

        JLabel date = new JLabel("Join Date");
        date.setFont(font);
        date.setBounds(50, 250, 200, 30);
        add(date);

        dateofjoin = new JTextField();
        dateofjoin.setBounds(280, 250, 200, 30);
        dateofjoin.setFont(font);
        add(dateofjoin);

        JLabel mobile = new JLabel("Mobile NO");
        mobile.setFont(font);
        mobile.setBounds(50, 300, 200, 30);
        add(mobile);

        mobileno = new JTextField();
        mobileno.setBounds(280, 300, 200, 30);
        mobileno.setFont(font);
        add(mobileno);

        JLabel address_label = new JLabel("Address ");
        address_label.setFont(font);
        address_label.setBounds(50, 350, 200, 30);
        add(address_label);

        address = new JTextField();
        address.setBounds(280, 350, 200, 30);
        address.setFont(font);
        add(address);

        JLabel roomnoLabel=new JLabel("Room NO");
        roomnoLabel.setFont(font);
        roomnoLabel.setBounds(50,400,200,30);
        add(roomnoLabel);

        roomno=new JTextField();
        roomno.setFont(font);
        roomno.setBounds(280,400,200,30);
        add(roomno);

        JLabel bedidLabel=new JLabel("Bed ID");
        bedidLabel.setFont(font);
        bedidLabel.setBounds(50,450,200,30);
        add(bedidLabel);

        bedid=new JTextField();
        bedid.setFont(font);
        bedid.setBounds(280,450,200,30);
        add(bedid);

        JLabel paymentLabel=new JLabel("Payment Status");
        paymentLabel.setFont(font);
        paymentLabel.setBounds(50,500,200,30);
        add(paymentLabel);

        paymentDetail=new JTextField();
        paymentDetail.setFont(font);
        paymentDetail.setBounds(280,500,200,30);
        add(paymentDetail);

        JLabel TotalAmtLabel=new JLabel("Total Amount ");
        TotalAmtLabel.setFont(font);
        TotalAmtLabel.setBounds(50,550,200,30);
        add(TotalAmtLabel);

        totalAmt=new JTextField();
        totalAmt.setFont(font);
        totalAmt.setBounds(280,550,200,30);
        add(totalAmt);







        submit=new JButton("Submit");
        submit.setFont(font);
        submit.setBounds(150,600,100,40);
        add(submit);
        submit.addActionListener(this);



    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            try {
                String custid=searchCustomer.getSelectedItem();
                Java_Con con=new Java_Con();
                con.createCon();
                ResultSet rs=con.stmt.executeQuery("select * from customer where customerid='"+custid+"';");

                while (rs.next()) {
                    Custname.setText(rs.getString("name"));
                    customerid.setText(rs.getString("customerid"));
                    gender.setText(rs.getString("gender"));
                    dateofjoin.setText(rs.getString("dateofjoin"));
                    address.setText(rs.getString("address"));
                    mobileno.setText(rs.getString("mobileno"));
                }
                ResultSet rs2=con.stmt.executeQuery("select *from customerroomdetail where customerid='"+custid+"';");

                while (rs2.next()){
                    roomno.setText(rs2.getString("roomno"));
                    bedid.setText(rs2.getString("bedid"));
                    paymentDetail.setText(rs2.getString("paymentstatus"));
                    totalAmt.setText(rs2.getString("totalamount"));

                }

            }
            catch (Exception e){
                JOptionPane.showMessageDialog(this,"Error : +"+e.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        new Remove_Customer();
    }

}

