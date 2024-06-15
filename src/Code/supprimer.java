package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class supprimer extends JFrame implements ActionListener {
    EtudiantDAO dao;
    JTextField cinField;
    JButton btn2,btn;
    supprimer(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel cinLabel = new JLabel("CIN:");
        cinLabel.setBounds(40, 30, 100, 30);
        add(cinLabel);

        cinField = new JTextField();
        cinField.setBounds(150, 30, 150, 30);
        add(cinField);

        btn = new JButton("BACK");
        btn.setBounds(50, 70, 100, 50);
        btn.setForeground(Color.white);
        btn.setBackground(Color.decode("#751EAA"));
        btn.addActionListener(this);
        add(btn);

        btn2 = new JButton("DELETE");
        btn2.setBounds(180, 70, 100, 50);
        btn2.setForeground(Color.white);
        btn2.setBackground(Color.decode("#751EAA"));
        btn2.addActionListener(this);
        add(btn2);

        dao = new EtudiantDAO("jdbc:mysql://localhost:3306/projet_etudiant","root","");

        setSize(380, 210);
        setLocation(450, 200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new supprimer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn2) {
            int cin = Integer.parseInt(cinField.getText());
            try {
                int rowsAffected = dao.supprimer_Etudiant(cin);
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Étudiant supprimé avec succès");
                } else {
                    JOptionPane.showMessageDialog(this, "Aucun étudiant trouvé avec ce CIN");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btn) {
            setVisible(false);
            new Home();
        }
    }
}
