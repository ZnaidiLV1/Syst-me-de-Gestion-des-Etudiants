package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First_Page extends JFrame implements ActionListener {

    First_Page(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/first-Image.jpg"));
        Image i2 = i1.getImage().getScaledInstance(720,360,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(50,100,760,500);
        add(image);

        JLabel welcome= new JLabel("Systeme de Gestion des Etudiants");
        welcome.setBounds(50, 50, 450, 50);
        welcome.setFont(new Font("Raleway",Font.BOLD,25));
        welcome.setForeground(Color.WHITE);
        image.add(welcome);

        JButton btn= new JButton("Continuer");
        btn.setBounds(50,150,100,50);
        btn.setForeground(Color.black);
        btn.setBackground(Color.decode("#751EAA"));
        btn.addActionListener(this);
        image.add(btn);

        this.setVisible(true);
        this.setBounds(400,200,760,500);
        this.setLocation(200,100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new login();
    }
}
