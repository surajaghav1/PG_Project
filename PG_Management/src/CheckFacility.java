import javax.swing.*;
import java.awt.*;

public class CheckFacility extends JFrame {
    CheckFacility(){
        setLayout(null);
        setBounds(350,150,900,500);
        setVisible(true);

        ImageIcon icon=new ImageIcon("images/Room_facility.jpg");
        Image image=icon.getImage();
        Image newImage=image.getScaledInstance(900,500,Image.SCALE_SMOOTH);
        icon=new ImageIcon(newImage);
        JLabel l1=new JLabel(icon);
        l1.setBounds(0,0,900,500);
        add(l1);
    }

    public static void main(String[] args) {
        new CheckFacility();
    }
}
