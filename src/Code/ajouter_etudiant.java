package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ajouter_etudiant extends  JFrame implements ActionListener {
    JTextField nomField, prenomField, cinField, filiereField, sexeField, moyenneField;
    EtudiantDAO dao;
    ajouter_etudiant() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel nomLabel = new JLabel("Nom:");
        nomLabel.setBounds(40, 20, 100, 30);
        add(nomLabel);

        nomField = new JTextField();
        nomField.setBounds(150, 20, 150, 30);
        add(nomField);

        JLabel prenomLabel = new JLabel("Prénom:");
        prenomLabel.setBounds(40, 60, 100, 30);
        add(prenomLabel);

        prenomField = new JTextField();
        prenomField.setBounds(150, 60, 150, 30);
        add(prenomField);

        JLabel cinLabel = new JLabel("CIN:");
        cinLabel.setBounds(40, 100, 100, 30);
        add(cinLabel);

        cinField = new JTextField();
        cinField.setBounds(150, 100, 150, 30);
        add(cinField);

        JLabel moyenneLabel = new JLabel("Moyenne:");
        moyenneLabel.setBounds(40, 140, 100, 30);
        add(moyenneLabel);

        moyenneField = new JTextField();
        moyenneField.setBounds(150, 140, 150, 30);
        add(moyenneField);

        JLabel filiereLabel = new JLabel("Filière:");
        filiereLabel.setBounds(40, 180, 100, 30);
        add(filiereLabel);

        filiereField = new JTextField();
        filiereField.setBounds(150, 180, 150, 30);
        add(filiereField);

        JLabel sexeLabel = new JLabel("Sexe:");
        sexeLabel.setBounds(40, 220, 100, 30);
        add(sexeLabel);

        sexeField = new JTextField();
        sexeField.setBounds(150, 220, 150, 30);
        add(sexeField);


        JButton btn = new JButton("CREATE");
        btn.setBounds(300, 280, 100, 50);
        btn.setForeground(Color.white);
        btn.setBackground(Color.decode("#751EAA"));
        btn.addActionListener(this);
        add(btn);

        JButton btn2 = new JButton("BACK");
        btn2.setBounds(180, 280, 100, 50);
        btn2.setForeground(Color.white);
        btn2.setBackground(Color.decode("#751EAA"));
        btn2.addActionListener(this);
        add(btn2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/add.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        dao = new EtudiantDAO("jdbc:mysql://localhost:3306/projet_etudiant","root","");

        setSize(600, 410);
        setLocation(450, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ajouter_etudiant();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CREATE")) {
            // Retrieve values from text fields
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            int cin = Integer.parseInt(cinField.getText());
            double moyenne = Double.parseDouble(moyenneField.getText());
            String filiere = filiereField.getText();
            String sexe = sexeField.getText();
            try {
                int rowsAffected = dao.insert_Etudiant(nom, prenom, cin, moyenne, filiere, sexe);
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Étudiant ajouté avec succès");
                    nomField.setText("");
                    prenomField.setText("");
                    cinField.setText("");
                    moyenneField.setText("");
                    filiereField.setText("");
                    sexeField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Échec de l'ajout de l'étudiant");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("BACK")) {
            setVisible(false);
            new Home();
        }
    }
}
