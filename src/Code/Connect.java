package Code;

import Data_Base.MyConnexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    Connect(){
        String url ="jdbc:mysql://localhost:3306/projet_etudiant";
        String username ="root";
        String password="";
        Connection con = MyConnexion.get_Connection(url,username,password);
        Statement st = null;
        try {
            assert con != null;
            st = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = st.executeQuery("select * from etudiant");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            while(resultSet.next()) {
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
            }
        } catch (SQLException e) {
            System.out.println("SQL Execption : "+e.getMessage());
        }
    }
}
