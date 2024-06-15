package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener{

    JTextField userField, passwordField;

    login() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(40, 20, 100, 30);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(150, 20, 150, 30);
        add(userField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 70, 100, 30);
        add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(150, 70, 150, 30);
        add(passwordField);

        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.decode("#751EAA"));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/User.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(userField.getText().equalsIgnoreCase("admin") && passwordField.getText().equalsIgnoreCase("admin")){
            setVisible(false);
            new Home();
        } else {
            JOptionPane.showMessageDialog(null,"Username ou password Incorrect");
        }
    }

    public static void main(String[] args) {
        new login();
    }
}

