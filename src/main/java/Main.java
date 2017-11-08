import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int atsk;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Prideti klienta ir jo tyrimus 2.Perziureti ligu sarasa 3.Tyrymu normu sarasas 4.Klientu sarasas 5.Klientu diagnozes 0.Iseiti");
        atsk = scanner.nextInt();
        while(atsk != 0){
            if(atsk == 1)
            {

                Scanner sc = new Scanner(System.in);
                System.out.println("Iveskite Kliento varda :");
                String name = sc.nextLine();
                System.out.println("Iveskite Kliento pavarde :");
                String surname = sc.nextLine();
                System.out.println("Iveskite Kliento adresa : ");
                String adress = sc.nextLine();
                System.out.println("Iveskite Leukocitu kieki :");
                int leukocitai = sc.nextInt();
                System.out.println("Iveskite Eritrocitu kieki :");
                int eritrocitai = sc.nextInt();
                System.out.println("Iveskite Hemoglobinokieki :");
                int hemoglobinas = sc.nextInt();
                System.out.println("Iveskite Trombocitu_kieki :");
                int trombocitai = sc.nextInt();
                System.out.println("Iveskite Limfocitu kiekis :");
                int limfocitai = sc.nextInt();
                System.out.println("Iveskite  Neutrafilu kieki :");
                int neutrafilai = sc.nextInt();

               Prideti.pridejimas(name,surname,adress,leukocitai,eritrocitai,hemoglobinas,trombocitai,limfocitai,neutrafilai);
                atsk = 10;

            }else
            if(atsk == 2)
            {
                LiguSarasas.sarasas();
                atsk = 10;

            }
            else
            if(atsk == 3)
            {
                NormosSarasas.Sarasas_normu();
                atsk = 10;

            }
            else
            if(atsk == 4)
            {
                KlientuSarasas.sarasas();
                atsk = 10;

            }
            else
            if(atsk == 5)
            {
                RezultatuSarasas.sarasas();
                atsk = 10;

            }
            else {
                scanner = new Scanner(System.in);
                System.out.println("1.Prideti klienta ir jo tyrimus 2.Perziureti ligu sarasa 3.Tyrymu normu sarasas 4.Klientu sarasas 5.Klientu diagnozes 0.Iseiti");
                atsk = scanner.nextInt();
            }
        }
    }
}
