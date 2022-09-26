import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import festmeny.*;

public class Main {        
    public static List<festmeny> festmenyek = new ArrayList<>();
    public static void beker(){
        String fajlNev = "festmenyek.csv";
        try {
            beolv(fajlNev);
        } catch (FileNotFoundException e){
            System.err.printf("Nem található az %s fájl!", fajlNev);
        } catch (IOException e){
            System.err.println("Hiba történt a fájl beolvasása közben!");
        }
    }
    public static void beolv(String fajlNev) throws IOException {
        FileReader fr= new FileReader(fajlNev);
        BufferedReader br= new BufferedReader(fr);      
        String sor = br.readLine();
        while (sor != null && !sor.equals("")) {
            String[] elem = sor.split(";");
            festmeny festmeny  = new festmeny(elem[0],elem[1],elem[2]);
            festmenyek.add(festmeny);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
        beker();
        Scanner sr = new Scanner(System.in);   
        int i = 0;
        int hanyadik = 0;
        int mennyi = 0;
        String menu = "";
        while(i<1){
            System.out.println("Mit szeterne csinálni a(licit 10%) b(licit x%) c(x festmény adatai) d(kilépés)");
            menu = sr.next();
            if(menu.equals("d")){
                i++;
                System.out.print("Kilépés...");
            }else if(menu.equals("a")){
                System.out.print("Hanyadik festményre:");
                hanyadik = sr.nextInt();
                festmenyek.get(hanyadik).licit();
            }else if(menu.equals("b")){
                System.out.print("Hanyadik festményre:");
                hanyadik = sr.nextInt();
                System.out.print("Menyivel:");
                mennyi = sr.nextInt();
                festmenyek.get(hanyadik).licitmeret(mennyi);
            }else if(menu.equals("c")){
                System.out.print("Hanyadik festmény:");
                hanyadik = sr.nextInt();
                System.out.println(festmenyek.get(hanyadik).toString());
            }else{
                System.out.println("Hibaaaaaaaaaaaaaaaaaaaaaaaa! Próbáld újra!");
            }           
        }
    }
}        