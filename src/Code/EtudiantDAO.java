package Code;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import Data_Base.MyConnexion;
public class EtudiantDAO implements EtudiantDAOCRUD{
    Connection connection =null;
    public EtudiantDAO(String url, String login, String password){
        connection=MyConnexion.get_Connection(url,login,password);
        if (connection != null) {
            System.out.println("Connection initialized successfully.");
        } else {
            System.out.println("Connection is null.");
        }
    }

    @Override
    public int insert_Etudiant(String nom, String prenom, int cin, double moyenne,String filiere,String sexe) throws SQLException {
        String req="insert into Etudiant values(?,?,?,?,?,?)";
        PreparedStatement ps=null;
        if(connection!=null){
            ps=connection.prepareStatement(req);
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setInt(3,cin);
            ps.setDouble(4,moyenne);
            ps.setString(5,filiere);
            ps.setString(6,sexe);
        }
        return ps.executeUpdate();

    }

    @Override
    public int supprimer_Etudiant(int cin) throws SQLException {
        String req = "DELETE FROM Etudiant WHERE cin = ?";
        PreparedStatement ps = null;
        try {
            if (connection != null) {
                ps = connection.prepareStatement(req);
                ps.setInt(1, cin);
            } else {
                throw new SQLException("Connection is null.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ps.executeUpdate();
    }



    @Override
    public int modifier_Etudiant(int cin, String nom, String prenom, double moyenne,String filiere,String sexe) throws SQLException {
        String req = "UPDATE Etudiant SET nom = ?, prenom = ?, moyenne = ? ,filiere=?,sexe=? WHERE cin = ?";
        PreparedStatement ps = null;
        try {
            if (connection != null) {
                ps = connection.prepareStatement(req);
                ps.setString(1, nom);
                ps.setString(2, prenom);
                ps.setDouble(3, moyenne);
                ps.setInt(4, cin);
                ps.setString(5,filiere);
                ps.setString(6,sexe);
            } else {
                throw new SQLException("Connection is null.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ps.executeUpdate();
    }


    @Override
    public void affichet_tous(String req) throws SQLException {
        //Afficher tous les etudinats
        Statement statement = null;
        if(connection!=null) {
            System.out.println("ooo");
            statement = connection.createStatement();
        }
        ResultSet resultSet = statement.executeQuery("select * from Etudiant");
        while (resultSet.next()) {
            System.out.println("Le Nom : " + resultSet.getString(1) + " \nLe Prenom : " + resultSet.getString(2) + "\nCIN : " + resultSet.getInt(3) + "\nMoyenne : " + resultSet.getDouble(4)
            +"\nfiliere :"+resultSet.getString(5)+"\nsexe :"+resultSet.getString(6));
        }

        Statement st2=null;
        if(connection!=null)
        {
            st2=connection.createStatement();
        }
        String req2="select * from Etudiant";
        ResultSet rs2= st2.executeQuery(req2);
        while (rs2.next()){
            String nom=rs2.getString(1);
            String prenom=rs2.getString(2);
            int cin = rs2.getInt(3);
            double moyenne=rs2.getDouble(4);
            String filiere=rs2.getString(5);
            String sexe=rs2.getString(6);
            System.out.println(nom+"  "+prenom+ "  "+cin+ "  "+moyenne+"  "+filiere+"  "+sexe);
        }
    }
    public ResultSet selection(String req) throws SQLException {
        ResultSet rs=null;
        Statement st = null;
        if(connection!=null){
            st = connection.createStatement();
        }
        if(st!=null){
            rs=st.executeQuery(req);
        }
        return rs;
    }

}

