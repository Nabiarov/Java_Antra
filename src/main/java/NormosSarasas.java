import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class NormosSarasas {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/ligonine";
    static final String USER = "root";
    static final String PASS = "";

    public static void Sarasas_normu() {
        Connection conn = null;
        Statement stmt = null;
        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Leukocitu_kiekis_norm,Eritrocitu_kiekis_norm,Hemoglobino_kiekis_norm,Trombocitu_kiekis_norm,Limfocitu_kiekis_norm,Neutrafilu_kiekis_norm FROM normos";
            ResultSet rs = stmt.executeQuery(sql);
            List<Normos> normos = new ArrayList<>();
            while(rs.next()){
                int Leukocitu_kiekis_norm = rs.getInt("Leukocitu_kiekis_norm");
                int Eritrocitu_kiekis_norm = rs.getInt("Eritrocitu_kiekis_norm");
                int Hemoglobino_kiekis_norm = rs.getInt("Hemoglobino_kiekis_norm");
                int Trombocitu_kiekis_norm = rs.getInt("Trombocitu_kiekis_norm");
                int Limfocitu_kiekis_norm = rs.getInt("Limfocitu_kiekis_norm");
                int Neutrafilu_kiekis_norm = rs.getInt("Neutrafilu_kiekis_norm");

                normos.add(new Normos(Leukocitu_kiekis_norm,Eritrocitu_kiekis_norm,Hemoglobino_kiekis_norm,Trombocitu_kiekis_norm,Limfocitu_kiekis_norm,Neutrafilu_kiekis_norm));
            }
            rs.close();
            stmt.close();
            conn.close();

            for (Normos norma: normos) {
                System.out.println("Leukocitu norma : "+norma.getLeukocitu_kiekis_norm() +"  Eritrocitu norma :  "+ norma.getEritrocitu_kiekis_norm()+"  Hemoglobino norma :  "+norma.getHemoglobino_kiekis_norm()+"  Trombocitu norma :  "+norma.getTrombocitu_kiekis_norm()+"  Limfocitu norma :  "+norma.getLimfocitu_kiekis_norm()+"  Neutrafilu :  "+norma.getNeutrafilu_kiekis_norm());
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
