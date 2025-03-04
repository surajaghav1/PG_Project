import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Add_Room extends JFrame implements ActionListener {

    int roomno,bedCapacity=0;
    JTextField roomNoTextfield,bedNoTextfield;
    JComboBox Roomstatus,BedIdCombo; // it will give the status of room, i.e. room is available or occupied
    String bedid;  // bed id for a single room like (R-roomNo- B- bedNO) R-102-B-01,B-02
    String BedStatus; // it will give the status of the bed like which bed is allocated or which is empty
                        // ex : B-01 => Available  or B-02 => Occupied
                        // if all beds occupied then room is occupied
    String bedStatus;   // it will gives the status of bed, i.e. how many beds are occupied or how many are empty

    JButton submit,back;
    JLabel BedIdComboLabel;
    Add_Room(){
        // frame
        setLayout(null);
        setBounds(400,40,800,800);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Room or Bed ");

        JLabel heading=new JLabel("ADD Room or Bed to The Room");
        heading.setFont(new Font("Engravers MT",Font.BOLD,30));
        heading.setBounds(50,30,700,50);
        add(heading);

        // adding images to the frame
        JPanel panel=new JPanel();
        panel.setBounds(500,100,300,500);
        panel.setBackground(new Color(255, 255, 255, 50));
        panel.setLayout(null);
        add(panel);

        ImageIcon icon=new ImageIcon("images/Room_2.jpeg");
        Image image=icon.getImage();
        Image newImage=image.getScaledInstance(300,600,Image.SCALE_SMOOTH);
        icon=new ImageIcon(newImage);
        JLabel l1=new JLabel("",icon,JLabel.CENTER);
        l1.setBounds(0,0,300,600);
        panel.add(l1);

    // Actual Code

        Font font=new Font("Arial",Font.PLAIN,20);

        JLabel roomnoLabel=new JLabel("Enter Room No ");
        roomnoLabel.setBounds(50,100,200,40);
        roomnoLabel.setFont(font);
        add(roomnoLabel);

        roomNoTextfield=new JTextField();
        roomNoTextfield.setBounds(280,100,200,40);
        roomNoTextfield.setFont(font);
        add(roomNoTextfield);

        JLabel bedCapacityLabel=new JLabel("Enter Bed Capacity");
        bedCapacityLabel.setBounds(50,160,200,40);
        bedCapacityLabel.setFont(font);
        add(bedCapacityLabel);

        bedNoTextfield=new JTextField();
        bedNoTextfield.setBounds(280,160,200,40);
        bedNoTextfield.setFont(font);
        add(bedNoTextfield);

        JLabel roomStatusLabel=new JLabel("Choose room status");
        roomStatusLabel.setFont(font);
        roomStatusLabel.setBounds(50,220,200,40);
        add(roomStatusLabel);


        String status[]={"Available","Occupied"};
        Roomstatus=new JComboBox(status);
        Roomstatus.setFont(font);
        Roomstatus.setBounds(280,220,200,40);
        add(Roomstatus);
        Roomstatus.addActionListener(this);

        JLabel bedIdLabel=new JLabel("Bed Id's ");
        bedIdLabel.setBounds(50,280,200,40);
        bedIdLabel.setFont(font);
        add(bedIdLabel);

        BedIdComboLabel=new JLabel("Data");
        BedIdComboLabel.setFont(font);
        BedIdComboLabel.setBounds(280,280,200,40);
        add(BedIdComboLabel);

        submit=new JButton("SUBMIT");
        submit.setBounds(50,340,150,40);
        add(submit);
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.addActionListener(this);

        back=new JButton("BACK");
        back.setBounds(220,340,150,40);
        add(back);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);

        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);

        }
        else if(ae.getSource()==submit){
            Java_Con con=new Java_Con();

            String roomStatus=Roomstatus.getSelectedItem().toString();
            String bedid="";
            for(int i=0;i<BedIdCombo.getItemCount();i++){
                String bd="";
                bedid+=BedIdCombo.getItemAt(i)+",";
                bd= (String) BedIdCombo.getItemAt(i);
                try {
                    con.createCon();
                    String status="Available";
                    con.stmt.executeUpdate("insert into beddetail values('"+roomno+"','"+bd+"','"+status+"');");
//                    JOptionPane.showMessageDialog(this,"Data inserted 'Bed Details'");
                }
                catch (Exception e){
                    System.out.println(e+"Bed details errro");
                    JOptionPane.showMessageDialog(this,"Error in BED ");
                }
            }
            try {
//                String query="insert into room values("+roomno+","+bedCapacity+","+Roomstatus+","+bedid+","+"null)";
                con.createCon();
                PreparedStatement pstmt=con.con.prepareStatement("insert into room values(?,?,?,?)");

                pstmt.setInt(1,roomno);
                pstmt.setInt(2,bedCapacity);
                pstmt.setString(3,roomStatus);
                pstmt.setString(4,bedid);
//                pstmt.setString(5,"123");

                int i=pstmt.executeUpdate();
                System.out.println("row inserted into Table ");
//                        con.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(this,"Bed inserted to the room successfully");


            }
            catch (Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(this,"Error ");
            }

        }
        if(ae.getSource()==Roomstatus) {
            if (Roomstatus.getSelectedItem().toString().equals("Available")) {

                // printing ddetails
                String n = roomNoTextfield.getText();
                roomno = Integer.parseInt(n);
                System.out.println("nube" + n);

                String b = bedNoTextfield.getText();
                bedCapacity = Integer.parseInt(b);
                System.out.println("bed capacity : " + b);

                System.out.println("Room no is : " + roomno);
                System.out.println("Bed capacity is : " + bedCapacity);

                int id = 1;
                String room[] = new String[bedCapacity];
                for (int i = 0; i < room.length; i++) {
                    room[i] = "R-"+roomno+"-B-0" + id;
                    bedid = room[i];
                    ++id;
                }
                BedIdComboLabel.setVisible(false);

                BedIdCombo=new JComboBox(room);
//                BedIdCombo.setFont(font);
                BedIdCombo.setBounds(280,280,200,40);
                add(BedIdCombo);
                // setting the Bed ID
                System.out.println("The total bed with id's");
                for (String a : room) {
                    System.out.print(a + "\t");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Add_Room();
    }
}
