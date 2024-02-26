import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public interface Serializable {
    void zapiszZamowienie(String nazwaPliku);


    public void wczytajZamowienie(String nazwaPliku);

}
