package Code;

import java.sql.SQLException;
import java.sql.Statement;

public interface EtudiantDAOCRUD {
    public int insert_Etudiant(String nom,String prenom,int cin ,double moyenne,String filiere,String sexe) throws SQLException;
    public int supprimer_Etudiant (int cin) throws SQLException;
    int modifier_Etudiant(int cin, String nom, String prenom, double moyenne,String filiere,String sexe) throws SQLException;
    public void affichet_tous(String req) throws SQLException;
}
