public class Klientas {


    private String Vardas;
    private String Pavarde;
    private String Adresas;
    private int Leukocitu_kiekis;
    private int Eritrocitu_kiekis;
    private int Hemoglobino_kiekis;
    private int Trombocitu_kiekis;
    private int Limfocitu_kiekis;
    private int Neutrafilu_kiekis;

    public Klientas(String Vardas, String Pavarde, String Adresas, int Leukocitu_kiekis, int Eritrocitu_kiekis, int Hemoglobino_kiekis, int Trombocitu_kiekis, int Limfocitu_kiekis, int Neutrafilu_kiekis){

        this.Vardas = Vardas;
        this.Pavarde = Pavarde;
        this.Adresas = Adresas;
        this.Leukocitu_kiekis = Leukocitu_kiekis;
        this.Eritrocitu_kiekis = Eritrocitu_kiekis;
        this.Hemoglobino_kiekis = Hemoglobino_kiekis;
        this.Trombocitu_kiekis = Trombocitu_kiekis;
        this.Limfocitu_kiekis = Limfocitu_kiekis;
        this.Neutrafilu_kiekis = Neutrafilu_kiekis;
    }
    public String getVardas(){
        return Vardas;
    }
    public String getPavarde(){ return Pavarde; }
    public String getAdresas(){
        return Adresas;
    }
    public int getLeukocitu_kiekis (){ return Leukocitu_kiekis;}
    public int getEritrocitu_kiekis(){ return Eritrocitu_kiekis;}
    public int getHemoglobino_kiekis() { return Hemoglobino_kiekis;}
    public int getTrombocitu_kiekis (){return Trombocitu_kiekis;}
    public int getLimfocitu_kiekis () { return Limfocitu_kiekis;}
    public int getNeutrafilu_kiekis () { return Neutrafilu_kiekis;}

    @Override
    public String toString(){
        return "Vardas :  " + Vardas + "\nPavarde : " + Pavarde + "\nAdresas: "  + Adresas + "\nLeukocitu kiekis : " + Leukocitu_kiekis + "\nEritrocitu kiekis : " + Eritrocitu_kiekis + "\nHemoglobino kiekis : " +Hemoglobino_kiekis+"\nTrombocitu kiekis : "+Trombocitu_kiekis +"\nLimfocitu kiekis : " +Limfocitu_kiekis+"\nNeutrafilu kiekis : "+Neutrafilu_kiekis +"\nVardo Hash kodas: " + Vardas.hashCode() + "\n" ;
    }


}