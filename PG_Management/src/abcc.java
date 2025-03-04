import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

public class abcc extends JFrame {
    abcc(){
        setLayout(null);
        setBounds(100,100,400,600);
        setVisible(true);

        String a[]={"abc","d","12"};
        JComboBox com=new JComboBox();
//        com.add("abc");
//        com.add("suraj");
        com.setBounds(10,10,100,40);
        add(com);

//       com.addItemListener(new ItemListener() {
//           @Override
//           public void itemStateChanged(ItemEvent e) {
//               System.out.println(com.getSelectedItem());
//
//           }
//       });

        String doclist[]={"Aadhaar Card","PAN Card","Driving License"};
       JComboBox DocumentType=new JComboBox(doclist);
        DocumentType.setBounds(280,200,200,30);
        DocumentType.setBackground(Color.white);
//        DocumentType.setFont(font);
        add(DocumentType);
        DocumentType.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("using item listener");
                System.out.println(DocumentType.getSelectedItem().toString());
            }
        });
//        System.out.println(DocumentType.getSelectedItem().toString());

        JButton button=new JButton("Submit");
        button.setBounds(100,150,100,40);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(DocumentType.getSelectedItem().toString());

            }
        });
        com.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(com.getSelectedItem());

            }
        });

    }
    public static void main(String[] args) {
        new abcc();
    }
}
