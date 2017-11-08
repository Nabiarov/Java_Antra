import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KlientuSarasas {

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
            sql = "SELECT Vardas,Pavarde,Adresas,Leukocitu_kiekis,Eritrocitu_kiekis,Hemoglobino_kiekis,Trombocitu_kiekis,Limfocitu_kiekis,Neutrafilu_kiekis  FROM klientas";
            ResultSet rs = stmt.executeQuery(sql);
            List<Klientas> klientai = new ArrayList<>();
            while(rs.next()){
                String vardas = rs.getString("Vardas");
                String pavarde = rs.getString("Pavarde");
                String adresas = rs.getString("Adresas");
                int leukocitu_kiekis = rs.getInt("Leukocitu_kiekis");
                int eritrocitu_kiekis = rs.getInt("Eritrocitu_kiekis");
                int hemoglobino_kiekis = rs.getInt("Hemoglobino_kiekis");
                int trombocitu_kiekis = rs.getInt("Trombocitu_kiekis");
                int limfocitu_kiekis = rs.getInt("Limfocitu_kiekis");
                int neutrafilu_kiekis = rs.getInt("Neutrafilu_kiekis");
                klientai.add(new Klientas(vardas,pavarde,adresas,leukocitu_kiekis,eritrocitu_kiekis,hemoglobino_kiekis,trombocitu_kiekis,limfocitu_kiekis,neutrafilu_kiekis));
            }
            rs.close();
            stmt.close();
            conn.close();

            for (Klientas klientura: klientai) {
                System.out.println("Kliento vardas : "+klientura.getVardas() +" Kliento pavarde :  "+ klientura.getPavarde()+" Kliento adresas:  "+klientura.getAdresas()+" Leukocitu kiekis:  "+klientura.getLeukocitu_kiekis()+" Eritrocitu skaicius:  "+klientura.getEritrocitu_kiekis()+" Hemoglobino kiekis:  "+klientura.getHemoglobino_kiekis()+" Trombocitu kiekis:  "+klientura.getTrombocitu_kiekis()+" Limfocitu kiekis:  "+klientura.getLimfocitu_kiekis()+" Neutrafilu kiekis:  "+klientura.getNeutrafilu_kiekis());
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
