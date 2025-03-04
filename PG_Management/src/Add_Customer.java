import com.toedter.calendar.JDateChooser;

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.sql.ResultSet;
import java.util.StringTokenizer;

public class Add_Customer extends JFrame implements ActionListener {
    JButton submit,back,clear;
    // choose file not in use now
    JButton checkFacility; // it open the new window of photo which contain photo of facility
//    JButton chooseFile   // =>> we are not using it

    JComboBox DocumentType,roomtype,defaultFacility;
    JCheckBox c2,c4;
//    c1,c2 not use
    JLabel document, note,lastnote;
    JDateChooser joindate;
    JRadioButton male,female;
    int amount=10000,addFacilityamount=0,payableAmount=0;

    JTextField Custname,MobileNO,Address,Original_Doc;
    // JTextField Facilities,Email;  =>> not in use
    Add_Customer(){

        try {
            Java_Con con=new Java_Con();
            con.createCon();
            ResultSet rs=con.stmt.executeQuery("select * from beddetail");
            if(rs.next()){

            }
            else {
                JOptionPane.showMessageDialog(this,"There is no empty room please enter new room first");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        // frame
        setLayout(null);
        setBounds(400,40,800,800);


        //        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Add Customer ");

        JLabel heading=new JLabel("ADD CUSTOMER");
        heading.setFont(new Font("Engravers MT",Font.BOLD,30));
        heading.setBounds(230,30,400,50);
        add(heading);

        // adding images to the frame
        JPanel panel=new JPanel();
        panel.setBounds(500,100,300,500);
        panel.setBackground(new Color(255, 255, 255, 50));
        panel.setLayout(null);
        add(panel);

        ImageIcon icon=new ImageIcon("images/customer.jpg");
        Image image=icon.getImage();
        Image newImage=image.getScaledInstance(300,600,Image.SCALE_SMOOTH);
        icon=new ImageIcon(newImage);
        JLabel l1=new JLabel("",icon,JLabel.CENTER);
        l1.setBounds(0,0,300,600);
        panel.add(l1);

// Actual code

        Font font=new Font("Arial",Font.PLAIN,20);

        JLabel name=new JLabel("Enter Name");
        name.setBounds(50,100,200,30);
        name.setFont(font);
        add(name);

        Custname=new JTextField();
        Custname.setBounds(280,100,200,30);
        Custname.setFont(font);
        add(Custname);

        JLabel gender=new JLabel("Select Gender ");
        gender.setFont(font);
        gender.setBounds(50,150,200,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setFont(font);
        male.setBounds(280,150,100,30);
        add(male);

        female=new JRadioButton("Female");
        female.setFont(font);
        female.setBounds(380,150,100,30);
        add(female);

        ButtonGroup bgGender=new ButtonGroup();
        bgGender.add(male);
        bgGender.add(female);


        JLabel doctype=new JLabel("Select Document");
        doctype.setFont(font);
        doctype.setBounds(50,200,200,30);
        add(doctype);

        String doclist[]={"Aadhaar Card","PAN Card","Driving License"};
         DocumentType=new JComboBox(doclist);
        DocumentType.setBounds(280,200,200,30);
        DocumentType.setBackground(Color.white);
        DocumentType.setFont(font);
        add(DocumentType);

        DocumentType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    String a=DocumentType.getSelectedItem().toString();
                    document.setText("");
                    document.setText("Enter "+a+" NO ");
                }
            }
        });

         document=new JLabel("Enter Aadhaar Card NO");
        document.setFont(font);
        document.setBounds(50,250,250,30);
        add(document);

        // it is document number which was given by user ==>> customer id
        Original_Doc=new JTextField();
        Original_Doc.setFont(font);
        Original_Doc.setBounds(280,250,200,30);
        add(Original_Doc);

//        JLabel file=new JLabel("Upload Above File");
//        file.setFont(font);
//        file.setBounds(50,280,200,40);
//        add(file);
//
//       chooseFile=new JButton("Choose File");
//       chooseFile.setBounds(260,280,150,40);
//       chooseFile.setFont(font);
//       chooseFile.addActionListener(this);
//       add(chooseFile);

        JLabel date=new JLabel("Enter Join Date");
        date.setFont(font);
        date.setBounds(50,300,200,30);
        add(date);

         joindate= new JDateChooser();
         joindate.setFont(font);
         joindate.setBounds(280,300,200,30);
         add(joindate);

//        chooseFile=new JButton("Choose File");
//        chooseFile.setBounds(280,280,150,40);
//        chooseFile.setFont(font);
//        chooseFile.addActionListener(this);
//        add(chooseFile);

    JLabel mobile=new JLabel("Enter Mobile NO");
        mobile.setFont(font);
        mobile.setBounds(50,350,200,30);
        add(mobile);

       MobileNO=new JTextField();
        MobileNO.setBounds(280,350,200,30);
        MobileNO.setFont(font);
       add(MobileNO);

        JLabel address_label=new JLabel("Enter Address ");
        address_label.setFont(font);
        address_label.setBounds(50,400,200,30);
        add(address_label);

        Address=new JTextField();
        Address.setBounds(280,400,200,30);
        Address.setFont(font);
        Address.addActionListener(this);
        add(Address);


        // NO NEED TO Gmail
//       JLabel email_label=new JLabel("Enter Room Type");
//        email_label.setFont(font);
//        email_label.setBounds(50,400,200,40);
//        add(email_label);

//       Email=new JTextField();
//        Email.setBounds(250,400,200,40);
//        Email.setFont(font);
//        Email.addActionListener(this);
//        add(Email);

// Roomtype

        JLabel roomlabel=new JLabel("Enter Room Type");
        roomlabel.setFont(font);
        roomlabel.setBounds(50,450,200,30);
        add(roomlabel);

        String roomtypelabel[]={"2 Sharing","3 Sharing","4 Sharing","5 Sharing","6 Sharing"};
        roomtype=new JComboBox(roomtypelabel);
        roomtype.setBounds(280,450,200,30);
        roomtype.setFont(font);
        roomtype.setBackground(Color.white);
        add(roomtype);

        roomtype.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem().toString().equals("2 Sharing")){
                note.setText("");
                String text=roomtype.getSelectedItem().toString();
                amount=0;
                amount+=10000;
                note.setText("* NOTE: Rent with basic facility and "+text+" is : RS."+amount);
                }
                if(e.getItem().toString().equals("3 Sharing")){
                note.setText("");
                String text=roomtype.getSelectedItem().toString();
                amount=0;
                amount+=9000;
                note.setText("* NOTE: Rent with basic facility and "+text+" is : RS."+amount);
                }
                if(e.getItem().toString().equals("4 Sharing")){
                note.setText("");
                String text=roomtype.getSelectedItem().toString();
                amount=0;
                amount+=8000;
                note.setText("* NOTE: Rent with basic facility and "+text+" is : RS."+amount);
                }
                if(e.getItem().toString().equals("5 Sharing")){
                note.setText("");
                String text=roomtype.getSelectedItem().toString();
                amount=0;
                amount+=7000;
                note.setText("* NOTE: Rent with basic facility and "+text+" is : RS."+amount);
                } if(e.getItem().toString().equals("6 Sharing")){
                note.setText("");
                String text=roomtype.getSelectedItem().toString();
                amount=0;
                amount+=6500;
                note.setText("* NOTE: Rent with basic facility and "+text+" is : RS."+amount);
                }
            }
        });



JLabel facility_label=new JLabel("Basic Facilities are");
        facility_label.setFont(font);
        facility_label.setBounds(50,500,200,30);
        add(facility_label);

        String deffacility[]={"Bed","WiFi","Cleaning","Breakfast","Dinner"};
        defaultFacility=new JComboBox(deffacility);
        defaultFacility.setBackground(Color.white);
        defaultFacility.setBounds(280,500,200,30);
        defaultFacility.setFont(font);
        add(defaultFacility);
        defaultFacility.setEditable(false);
//        System.out.println("*********");


//       Facilities=new JTextField();
//        Facilities.setBounds(280,520,200,40);
//        Facilities.setFont(font);
//        Facilities.setText();
//        Facilities.addActionListener(this);
//        add(Facilities);

        // note for basic facility
         note=new JLabel("* NOTE : Rent with basic facility : RS.10000");
        note.setBounds(50,540,350,30);
        add(note);

        checkFacility=new JButton("Check Facilities");
        checkFacility.setFont(font);
        checkFacility.setBounds(50,580,200,20);
        add(checkFacility);
        checkFacility.setBackground(Color.BLACK);
        checkFacility.setForeground(Color.white);
        checkFacility.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckFacility();
            }
        });


        JLabel facility_check=new JLabel("Choose Facilities");
        facility_check.setFont(font);
        facility_check.setBounds(50,610,200,30);
        add(facility_check);

//        c1=new JCheckBox("Breakfast",true);
//        c1.setFont(font);
//        c1.setBounds(280,580,150,40);
//        add(c1);
      c2=new JCheckBox("Lunch",false);
        c2.setFont(font);
        c2.setBounds(250,610,150,30);
        add(c2);
        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c2.isSelected()){
                String text=c2.getText();
                addFacilityamount+=2000;
                lastnote.setText("NOTE : Rent with additional facility "+text+" : RS."+addFacilityamount);
                }
                else {
                String text=c2.getText();
                addFacilityamount-=2000;
                lastnote.setText("NOTE : Rent with additional facility "+text+" : RS."+addFacilityamount);
                }
            }
        });
//     c3=new JCheckBox("Dinner",true);
//        c3.setFont(font);
//        c3.setBounds(250,640,150,40);
//        add(c3);

      c4=new JCheckBox("Laundry",false);
        c4.setFont(font);
        c4.setBounds(420,610,150,30);
        add(c4);
        c4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c4.isSelected()){
                    String text=c4.getText();
                    addFacilityamount+=1000;
                    lastnote.setText("NOTE : Rent with additional facility "+text+" : RS."+addFacilityamount);
                }
                else{   String text=c4.getText();
                    addFacilityamount-=1000;
                    lastnote.setText("NOTE : Rent with additional facility "+text+" : RS."+addFacilityamount);
                }
            }
        });

        lastnote=new JLabel("* NOTE : Rent with additional facility : RS.0");
        lastnote.setBounds(50,650,300,30);
        add(lastnote);

        submit=new JButton("NEXT");
        submit.setBounds(150,700,100,40);
        submit.addActionListener(this);
        add(submit);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);

        clear=new JButton("CLEAR");
        clear.setBounds(270,700,100,40);
        clear.addActionListener(this);
        add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);


        back=new JButton("BACK");
        back.setBounds(390,700,100,40);
        back.addActionListener(this);
        add(back);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);

        setUndecorated(true);
        setVisible(true);
    }

public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back) {
            this.setVisible(false);
        }

        else if(ae.getSource()==clear){
                Custname.setText("");
                MobileNO.setText("");
                Address.setText("");
                Original_Doc.setText("");
                defaultFacility.setSelectedItem("");
                DocumentType.setSelectedItem("");
                roomtype.setSelectedItem("");
                c2.setSelected(false);
                c4.setSelected(false);
            }

            else if(ae.getSource()==submit) {

            // get total amount of payable :  =>> this amount send to next frame
            payableAmount = addFacilityamount + amount;
            String name = Custname.getText();
            String gender = "";
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            String mobile = MobileNO.getText();
//            String email=Email.getText();
            // pass that roomType to the next frame Room for room allocating : ********
            String roomType = (String) roomtype.getSelectedItem();

            String addr = Address.getText();
            String dateofJoin = ((JTextField) joindate.getDateEditor().getUiComponent()).getText();
            String doctype = DocumentType.getSelectedItem().toString();
            String doc = Original_Doc.getText(); // document number
            String facility = "";
            for (int i = 0; i < defaultFacility.getItemCount(); i++) {
                System.out.println("Component : " + defaultFacility.getItemAt(i));
                facility += defaultFacility.getItemAt(i) + ",";
            }
            String additionalFacility = "";
//            if(c1.isSelected()){
//                additionalFacility+=c1.getText()+",";
//            }
            if (c2.isSelected()) {
                additionalFacility += c2.getText() + ",";
            }
//            if(c3.isSelected()){
//                additionalFacility+=c3.getText()+",";
//            }
            if (c4.isSelected()) {
                additionalFacility += c4.getText() + ",";
            }

            System.out.println("The details you filled : ");
            System.out.println("Name : " + name);
            System.out.println("moibile : " + mobile);
            System.out.println("Room type  : " + roomType);
            System.out.println("addr : " + addr);
            System.out.println("doc : " + doc);
            System.out.println("facility : " + facility);
            System.out.println("Doctype  : " + doctype);
            System.out.println("Additional Facility : " + additionalFacility);
            System.out.println("JOINING Date : " + dateofJoin);


            // create the object of Addhar and pan
            aadhar_pan_validation id_valid = new aadhar_pan_validation();


//            String doclist[]={"Aadhaar Card","PAN Card","Driving License"

            switch (doctype) {
                case "Aadhaar Card":
                    if (!id_valid.isValidAadhar(doc)) {
                        JOptionPane.showMessageDialog(null, "Please Enter Correct Aadhar Number");
                    }
                    break;
                case "PAN Card":
                    if (!id_valid.isValidPan(doc)) {
                        JOptionPane.showMessageDialog(null, "Please Enter Correct PAN Number");
                    }
                    break;
                case "Driving License":
                    if (!id_valid.isValidDrivingLicenseNumber(doc)) {
                        JOptionPane.showMessageDialog(null, "Please Enter Correct Driving Licence  Number");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please Choose Any Id");
                    break;
            }

//  validation for all fields
            if (name.equals("") || addr.equals("") || doc.equals("") || gender.equals("") || mobile.equals("") || dateofJoin.equals("")) {
                JOptionPane.showMessageDialog(null, "All Fields are Manadatory ");
            } else if (!id_valid.isValidName(name)) {
                JOptionPane.showMessageDialog(null, "Name is NOT Valid !! Pleasse Enter Valid Name");
            }
//            else if(!id_valid.isValidName(country)){
//                JOptionPane.showMessageDialog(null,"Please Enter Correct Country Name");
//            }
            else if (!id_valid.isValidMobileNumber(mobile)) {
                JOptionPane.showMessageDialog(null, "Please Enter Correct Mobile Number \n Only numbers allowed");
            } else {
                // insert into the customer table
                try {
                    Java_Con con = new Java_Con();
                    con.createCon();
                    String query = "insert into customer values('" + doc + "','" + name + "','" + gender + "','" + doctype + "','" + dateofJoin + "','" + mobile + "','" + addr + "','" + roomType + "','" + facility + "','" + additionalFacility + "');";
                    con.stmt.executeUpdate(query);


                    JOptionPane.showMessageDialog(this, "Customer Registration successfully");
                    int msg = JOptionPane.showConfirmDialog(this, " The total Payable amount is : RS." + payableAmount + "\n Go for payment and book room");
                    if (msg == 0) {
                        new Room(roomType, payableAmount, doc);
                        this.setVisible(false);
                        //  NOTE *** =>> "doc" is a customer id
                    }
                } catch (Exception e) {
                    System.out.println("error");
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(this, "Error in inserting data to the table");
                }
            }
        }

    }

    public static void main(String[] args) {
        new Add_Customer();
    }
}
