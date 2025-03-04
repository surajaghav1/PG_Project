import javax.swing.*;
import java.awt.*;

public class Show_Rules extends JFrame {
    Show_Rules(){
        setLayout(null);
        setBounds(400,150,800,600);
        setVisible(true);

        ImageIcon icon=new ImageIcon("images/Rules_.jpg");
        Image image=icon.getImage();
        Image newImage=image.getScaledInstance(800,600,Image.SCALE_SMOOTH);
        icon=new ImageIcon(newImage);
        JLabel l1=new JLabel(icon);
        l1.setBounds(0,0,800,600);
        add(l1);

    }

    public static void main(String[] args) {
        new Show_Rules();
    }
}
