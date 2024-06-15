package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, remove;

    Home() {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Systeme De Gestion Des Etudiants");
        heading.setBounds(20, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Ajoueter Etudiant");
        add.setBounds(50, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("Afficher Etudiants");
        view.setBounds(220, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Modifier Etudiant");
        update.setBounds(50, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Supprimer Etudiant");
        remove.setBounds(220, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            setVisible(false);
            new ajouter_etudiant();
        } else if (e.getSource() == view) {
            setVisible(false);
            try {
                new Affiche();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == update) {
            setVisible(false);
        } else if (e.getSource() == remove) {
            setVisible(false);
            new supprimer();
        }
    }
    public static void main (String []args) {
    new Home();
    }
    }
