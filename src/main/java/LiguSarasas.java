import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LiguSarasas {

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
                sql = "SELECT Ligos_Pavadinimas,Ligos_Aprasymas,Ligos_Gydymas FROM ligos";
                ResultSet rs = stmt.executeQuery(sql);
                List<Ligos> ligos = new ArrayList<>();
                while(rs.next()){
                  String pavadinimas = rs.getString("Ligos_Pavadinimas");
                  String aprasymas = rs.getString("Ligos_Aprasymas");
                  String gydymas = rs.getString("Ligos_Gydymas");
                    ligos.add(new Ligos(pavadinimas,aprasymas,gydymas));
                }
                rs.close();
                stmt.close();
                conn.close();

                for (Ligos liga: ligos) {
                    System.out.println("Ligos pavadinimas : "+liga.getLigos_Pavadinimas() +"   Aprasymas :  "+ liga.getLigos_Aprasymas()+"   Gydymas :  "+liga.getLigos_Gydymas());
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

