import javax.swing.*;
import java.awt.*;

public class ShowQRcode extends JFrame {
    ShowQRcode(){
        setLayout(null);
        setBounds(350,150,400,500);
        setVisible(true);

        ImageIcon icon=new ImageIcon("images/Suraj_QR.jpg");
        Image image=icon.getImage();
        Image newImage=image.getScaledInstance(400,500,Image.SCALE_SMOOTH);
        icon=new ImageIcon(newImage);
        JLabel l1=new JLabel(icon);
        l1.setBounds(0,0,400,500);
        add(l1);

    }

    public static void main(String[] args) {
        new ShowQRcode();
    }
}
