public class Normos {

    private int Leukocitu_kiekis_norm;
    private int Eritrocitu_kiekis_norm;
    private int Hemoglobino_kiekis_norm;
    private int Trombocitu_kiekis_norm;
    private int Limfocitu_kiekis_norm;
    private int Neutrafilu_kiekis_norm;

    public Normos() {

    }
    public Normos (int Leukocitu_kiekis_norm,int Eritrocitu_kiekis_norm,int Hemoglobino_kiekis_norm,int Trombocitu_kiekis_norm,int Limfocitu_kiekis_norm,int Neutrafilu_kiekis_norm ){
        this.Leukocitu_kiekis_norm = Leukocitu_kiekis_norm;
        this.Eritrocitu_kiekis_norm = Eritrocitu_kiekis_norm;
        this.Hemoglobino_kiekis_norm = Hemoglobino_kiekis_norm;
        this.Trombocitu_kiekis_norm = Trombocitu_kiekis_norm;
        this.Limfocitu_kiekis_norm = Limfocitu_kiekis_norm;
        this.Neutrafilu_kiekis_norm = Neutrafilu_kiekis_norm;
    }

public int getLeukocitu_kiekis_norm(){
        return Leukocitu_kiekis_norm;
}
public int getEritrocitu_kiekis_norm(){ return Eritrocitu_kiekis_norm; }
public int getHemoglobino_kiekis_norm(){
    return Hemoglobino_kiekis_norm;
}
public int getTrombocitu_kiekis_norm(){
    return Trombocitu_kiekis_norm;
}
public int getLimfocitu_kiekis_norm(){
    return Limfocitu_kiekis_norm;
}
public int getNeutrafilu_kiekis_norm(){
    return Neutrafilu_kiekis_norm;
}
}

