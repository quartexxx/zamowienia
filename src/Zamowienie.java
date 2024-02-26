import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Zamowienie extends Pozycja implements Serializable {
    public ArrayList<Pozycja> pozycje = new ArrayList<>();
    public int ileDodanych;
    public int maksRozmiar;


    Zamowienie() {
        this.maksRozmiar = 10;
    }

    Zamowienie(int maksRozmiar) {
        this.maksRozmiar = maksRozmiar;
    }

    int i = 0;

    public void dodajPozycje(Pozycja p) {
        for (Pozycja part : pozycje) {
            if (p.nazwaTowaru.equals(part.nazwaTowaru)) {
                part.ileSztuk += p.ileSztuk;
                return;
            }
        }
        pozycje.add(p);

    }


    public double obliczWartosc() {
        double sum = 0;
        for (Pozycja part : pozycje) {
            if (part.ileSztuk >= 5) {
                sum += part.obliczWartoscZRabatem();
            } else {
                sum += part.cena * part.ileSztuk;
            }

        }
        return sum;


    }

    public String toString() {
        String finalString = "";
        for (Pozycja part : pozycje) {
            finalString = finalString.concat(part.nazwaTowaru + "\n");

        }
        return "\n" + "Zamówienie: " + "\n" + finalString + "Razem: " + Double.toString(obliczWartosc()) + "zł";
    }

    public void usunPozycje(int indeks) {
        pozycje.remove(indeks);
    }

    public void edytujPozycje(int indeks) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj zmienioną nazwe: ");
        String newName = sc.next();
        System.out.println("Podaj zmienioną cenę: ");
        Double newPrice = sc.nextDouble();
        System.out.println("Podaj zmienioną liczbę sztuk: ");
        int newSzt = sc.nextInt();
        pozycje.get(indeks).nazwaTowaru = newName;
        pozycje.get(indeks).cena = newPrice;
        pozycje.get(indeks).ileSztuk = newSzt;

    }


    @Override
    public void zapiszZamowienie(String nazwaPliku) {
        try {
            PrintWriter zapis = new PrintWriter(nazwaPliku);
            for (Pozycja part : pozycje) {
                zapis.print(part.nazwaTowaru + " ");
                zapis.print(part.cena + "zł" + " ");
                zapis.print(part.ileSztuk + "szt. " + " " + "\n");


            }
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
            while (in.hasNextLine()) {
                String zdanie = in.nextLine();
                System.out.println(zdanie);
            }


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
