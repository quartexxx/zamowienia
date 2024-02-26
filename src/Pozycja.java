import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pozycja implements Serializable {
    public String nazwaTowaru;
    public int ileSztuk;
    public double cena;

    public Pozycja(String nazwaTowaru, int ileSztuk, double cena) {
        this.nazwaTowaru = nazwaTowaru;
        this.ileSztuk = ileSztuk;
        this.cena = cena;
    }

    public Pozycja() {

    }

    private double obliczaWartosc() {
        double wynik = ileSztuk * cena;
        return wynik;

    }

    public String toString() {
        return String.format("%-20s %10.2f zł %4d szt %10.2f zł ", nazwaTowaru, cena, ileSztuk, obliczaWartosc());
    }


    public double obliczWartoscZRabatem() {
        double wartoscZRabatem = 0;
        double procent = obliczaWartosc() / 100;
        if (ileSztuk >= 5 && ileSztuk <= 10) {
            wartoscZRabatem = obliczaWartosc() - (procent * 5);
        } else if (ileSztuk >= 10 && ileSztuk <= 20) {
            wartoscZRabatem = obliczaWartosc() - (procent * 10);
        } else if (ileSztuk > 20) {
            wartoscZRabatem = obliczaWartosc() - (procent * 15);
        }
        return wartoscZRabatem;
    }

    public void zapiszZamowienie(String nazwaPliku) {
        try {
            PrintWriter zapis = new PrintWriter(nazwaPliku);
            zapis.print(nazwaTowaru + " ");
            zapis.print(cena + "zł" + " ");
            zapis.print(ileSztuk + "szt. " + " " + "\n");
            zapis.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void wczytajZamowienie(String nazwaPliku) {
        File file = new File(nazwaPliku);
        try {
            Scanner in = new Scanner(file);
            String zdanie = in.nextLine();
            System.out.println(zdanie);


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}





