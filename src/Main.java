public class Main {
    public static void main(String[] args) {
        Pozycja p1 = new Pozycja("Chleb", 1, 3);
        Pozycja p2 = new Pozycja("Cukier", 1, 4);
        Pozycja p3 = new Pozycja("Cukier", 1, 3);
        Zamowienie z = new Zamowienie(20);
        z.dodajPozycje(p1);
        z.dodajPozycje(p2);
        z.dodajPozycje(p3);
        z.wczytajZamowienie("zamowienie.txt");


    }
}