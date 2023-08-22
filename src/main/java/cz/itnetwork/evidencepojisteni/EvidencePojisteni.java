/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cz.itnetwork.evidencepojisteni;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EvidencePojisteni {
    public static void main(String[] args) {
        Databaze databaze = new Databaze();
        Scanner scanner = new Scanner(System.in);

        boolean run = true;

        while (run) {
            System.out.println("===== EVIDENCE POJISTNÝCH UDÁLOSTÍ =====");
            System.out.println("1. Vytvoření pojištěného");
            System.out.println("2. Zobrazení seznamu všech pojištěných");
            System.out.println("3. Vyhledání pojištěného podle jména a příjmení");
            System.out.println("0. Konec");

            int volba = scanner.nextInt();
            scanner.nextLine(); // Očištění bufferu

            switch (volba) {
                case 1:
                    vytvorPojisteneho(databaze, scanner);
                    break;
                case 2:
                    zobrazSeznamPojistencu(databaze);
                    break;
                case 3:
                    vyhledejPojisteneho(databaze, scanner);
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Neplatná volba, zkuste to znovu.");
                    break;
            }
        }
    }

    private static void vytvorPojisteneho(Databaze databaze, Scanner scanner) {
        System.out.println("Zadejte jméno pojištěného:");
        String jmeno = scanner.nextLine();

        System.out.println("Zadejte příjmení pojištěného:");
        String prijmeni = scanner.nextLine();

        System.out.println("Zadejte věk pojištěného:");
        int vek = scanner.nextInt();
        scanner.nextLine(); // Očištění bufferu

        System.out.println("Zadejte telefonní číslo pojištěného:");
        String telefonniCislo = scanner.nextLine();

        Pojistenec pojistenec = new Pojistenec(jmeno, prijmeni, vek, telefonniCislo);
        databaze.pridejPojistence(pojistenec);

        System.out.println("Pojištěnec byl úspěšně přidán do databáze.");
    }

    private static void zobrazSeznamPojistencu(Databaze databaze) {
        System.out.println("Seznam všech pojištěných:");
        databaze.vypisVsechnyPojistance();
    }

    private static void vyhledejPojisteneho(Databaze databaze, Scanner scanner) {
        System.out.println("Zadejte jméno a příjmení pojištěného pro vyhledání:");
        System.out.print("Jméno: ");
        String jmeno = scanner.nextLine();
        System.out.print("Příjmení: ");
        String prijmeni = scanner.nextLine();

       List<Pojistenec> nalzeniPojistenci = databaze.najdiPojistence(jmeno, prijmeni);
        if (nalzeniPojistenci != null) {
            System.out.println("Nalezený pojištěnec:");
            System.out.println(nalzeniPojistenci);
        } else {
            System.out.println("Pojištěnec nebyl nalezen.");
        }
    }
}


