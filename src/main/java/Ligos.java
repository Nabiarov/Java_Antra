public class Ligos {


        private String Ligos_Pavadinimas;
        private String Ligos_Aprasymas;
        private String Ligos_Gydymas;

    public Ligos(){

    }

        public Ligos(String Ligos_Pavadinimas,String Ligos_Aprasymas,String Ligos_Gydymas){

            this.Ligos_Pavadinimas = Ligos_Pavadinimas;
            this.Ligos_Aprasymas = Ligos_Aprasymas;
            this.Ligos_Gydymas = Ligos_Gydymas;
        }
        public String getLigos_Pavadinimas(){
            return Ligos_Pavadinimas;
        }
        public String getLigos_Aprasymas(){
            return Ligos_Aprasymas;
        }
        public String getLigos_Gydymas(){
            return Ligos_Gydymas;
        }
    }