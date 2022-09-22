import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import festmeny.*;

public class Main {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in); 
        String fajlNev = "festmenyek.csv";
        try {
            festmeny festmenye = new festmeny(fajlNev);
            System.out.println(festmenye);
        }catch(FileNotFoundException e) {
            System.err.printf("Hiba miatt nem található az %s fájl\n", fajlNev);
        }catch(IOException e){
            System.err.println("Ismeretlen hiba történt a fájl beolvasása során");
        }
        int i = 0;
        int hanyadik = 0;
        double menyi = 0;
        String menu = "";
        while(i<1){
            System.out.println("Mit szeterne csinálni a(licit 10%) b(licit x%) c(x festmény adatai) d(exit)");
            menu = sr.next();
            if(menu.equals("d")){
                i++;
            }else if(menu.equals("a")){
                System.out.print("Hanyadik festményre:");
                hanyadik = sr.nextInt();
            }else if(menu.equals("b")){
                System.out.print("Hanyadik festményre:");
                hanyadik = sr.nextInt();
                System.out.print("Menyivel:");
                menyi = sr.nextDouble();
            }else if(menu.equals("c")){
                System.out.print("Hanyadik festmény:");
                hanyadik = sr.nextInt();
            }else{
                System.out.println("Hibaaaaaaaaaaaaaaaaaaaaaaaa! Próbáld újra!");
            }           
        }
    }
}