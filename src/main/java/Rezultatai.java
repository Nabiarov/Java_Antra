public class Rezultatai {

    private String Vardas;
    private String Pavarde;
    private String Diagnoze;

    public Rezultatai(String vardas, String pavarde, String diagnoze) {
        this.Vardas = vardas;
        this.Pavarde = pavarde;
        this.Diagnoze = diagnoze;

    }
    public String getVardas() {
        return Vardas;
    }

    public String getPavarde() {
        return Pavarde;
    }

    public String getDiagnoze() {
        return Diagnoze;
    }

}
