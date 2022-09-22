import java.io.FileNotFoundException;
import java.io.IOException;

import festmeny.*;

public class Main {
    public static void main(String[] args) { 
        String fajlNev = "festmenyek.csv";
        try {
            festmeny festmenye = new festmeny(fajlNev);
            System.out.println(festmenye);
        }catch(FileNotFoundException e) {
            System.err.printf("Hiba miatt nem található az %s fájl\n", fajlNev);
        }catch(IOException e){
            System.err.println("Ismeretlen hiba történt a fájl beolvasása során");
        }
    }
}