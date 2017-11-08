import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RezultatuSarasas {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/ligonine";
    static final String USER = "root";
    static final String PASS = "";



    public static void sarasas() {
        Connection conn = null;
        Statement stmt = null;
        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Vardas,Pavarde,Diagnoze FROM rezultatas";
            ResultSet rs = stmt.executeQuery(sql);
            List<Rezultatai> rezultatai = new ArrayList<>();
            while(rs.next()){
                String vardas = rs.getString("Vardas");
                String pavarde = rs.getString("Pavarde");
                String diagnoze = rs.getString("Diagnoze");

                rezultatai.add(new Rezultatai(vardas,pavarde,diagnoze));
            }
            rs.close();
            stmt.close();
            conn.close();

            for (Rezultatai rezultatas: rezultatai) {
                System.out.println("Kliento vardas : "+rezultatas.getVardas() +"   Kliento pavarde :  "+ rezultatas.getPavarde()+"   Kliento diagnoze :  "+rezultatas.getDiagnoze());
            }
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}