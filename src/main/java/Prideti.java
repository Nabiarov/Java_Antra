import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prideti {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/ligonine";
    static final String USER = "root";
    static final String PASS = "";

    public static void pridejimas(String name,String surname,String adress,int leukocitai,int eritrocitai,int hemoglobinas,int trombocitai,int limfocitai,int neutrafilai) {
        Connection conn = null;
        Statement stmt = null;



        try {
            List<Rezultatai> rezultatai = new ArrayList<>();
            List<Klientas> klientas = new ArrayList<>();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "INSERT INTO klientas(Vardas, Pavarde, Adresas, Leukocitu_kiekis, Eritrocitu_kiekis, Hemoglobino_kiekis, Trombocitu_kiekis, Limfocitu_kiekis, Neutrafilu_kiekis) " +
                    "VALUES ('"+name+"','"+surname+"','"+adress+"','"+leukocitai+"','"+eritrocitai+"','"+hemoglobinas+"','"+trombocitai+"','"+limfocitai+"','"+neutrafilai+"')";
            stmt.executeUpdate(sql);

            klientas.add(new Klientas(name,surname,adress,leukocitai,eritrocitai,hemoglobinas,trombocitai,limfocitai,neutrafilai));

            System.out.println("Ligonis irasytas!");

            String sq2;
            sq2 = "SELECT Leukocitu_kiekis_norm,Eritrocitu_kiekis_norm,Hemoglobino_kiekis_norm,Trombocitu_kiekis_norm,Limfocitu_kiekis_norm,Neutrafilu_kiekis_norm FROM normos";
            ResultSet rs = stmt.executeQuery(sq2);


            List<Normos> norm = new ArrayList<>();
            while(rs.next()){
                int Leukocitu_kiekis_norm = rs.getInt("Leukocitu_kiekis_norm");
                int Eritrocitu_kiekis_norm = rs.getInt("Eritrocitu_kiekis_norm");
                int Hemoglobino_kiekis_norm = rs.getInt("Hemoglobino_kiekis_norm");
                int Trombocitu_kiekis_norm = rs.getInt("Trombocitu_kiekis_norm");
                int Limfocitu_kiekis_norm = rs.getInt("Limfocitu_kiekis_norm");
                int Neutrafilu_kiekis_norm = rs.getInt("Neutrafilu_kiekis_norm");

                norm.add(new Normos(Leukocitu_kiekis_norm,Eritrocitu_kiekis_norm,Hemoglobino_kiekis_norm,Trombocitu_kiekis_norm,Limfocitu_kiekis_norm,Neutrafilu_kiekis_norm));

            }




            if ( klientas.get(0).getLeukocitu_kiekis() > norm.get(0).getLeukocitu_kiekis_norm() && klientas.get(0).getHemoglobino_kiekis() < norm.get(0).getHemoglobino_kiekis_norm()) {
                String diagnoze = "Atopinis dermatitas";
                rezultatai.add(new Rezultatai(name,surname,diagnoze));

            }
            else if (klientas.get(0).getTrombocitu_kiekis() > norm.get(0).getTrombocitu_kiekis_norm() && klientas.get(0).getEritrocitu_kiekis()> norm.get(0).getEritrocitu_kiekis_norm()) {
                String diagnoze = "Persalimas";
                rezultatai.add(new Rezultatai(name,surname,diagnoze));
            }
            else if (klientas.get(0).getLimfocitu_kiekis() < norm.get(0).getLimfocitu_kiekis_norm() && klientas.get(0).getNeutrafilu_kiekis() > norm.get(0).getNeutrafilu_kiekis_norm()){
                String diagnoze = "Kepenu ciroze";
                rezultatai.add(new Rezultatai(name,surname,diagnoze));
            }
            else if (klientas.get(0).getLeukocitu_kiekis() < norm.get(0).getLeukocitu_kiekis_norm() && klientas.get(0).getHemoglobino_kiekis() > norm.get(0).getHemoglobino_kiekis_norm()) {
                String diagnoze = "Cukrinis diabetas";
                rezultatai.add(new Rezultatai(name,surname,diagnoze));
            }
            else if (klientas.get(0).getEritrocitu_kiekis() < norm.get(0).getEritrocitu_kiekis_norm() && klientas.get(0).getNeutrafilu_kiekis() < norm.get(0).getNeutrafilu_kiekis_norm()){
                String diagnoze = "Angina";
                rezultatai.add(new Rezultatai(name,surname,diagnoze));
            }
            else {
                String diagnoze = "Sveikas";
                rezultatai.add(new Rezultatai(name,surname,diagnoze));
            }


            for (Rezultatai rezultatas :rezultatai) {
                System.out.println("Diagnoze yra :");
                System.out.println(rezultatas.getVardas());
                System.out.println(rezultatas.getPavarde());
                System.out.println(rezultatas.getDiagnoze());


                String sq3 =  "INSERT INTO rezultatas(Vardas,Pavarde,Diagnoze) VALUES ('"+rezultatas.getVardas()+"','"+rezultatas.getPavarde()+"','"+rezultatas.getDiagnoze()+"')";
                stmt.executeUpdate(sq3);
            }




            rs.close();
            stmt.close();
            conn.close();


        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
