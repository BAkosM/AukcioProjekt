package festmeny;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class festmeny {
    private String cím;
    private String festo;
    private String stílus;   
    private int licitekSzama;
    private double licitMeret;
    private LocalDateTime legutsoLicit;
    private boolean elkelt;
    private ArrayList festmenyek;

    public festmeny() {
        this.cím = "";
        this.festo = "";
        this.stílus = "";
        this.licitekSzama = 0;    
        this.legutsoLicit = null;
        this.elkelt = false;
    }

    public festmeny(String cím, String festo, String stílus, int licitekSzama, LocalDateTime legutsoLicit,boolean elkelt) {
        this.cím = cím;
        this.festo = festo;
        this.stílus = stílus;
        this.licitekSzama = licitekSzama;
        this.legutsoLicit = legutsoLicit;
        this.elkelt = elkelt;
    }

    public festmeny(String fajlNev) throws IOException {
        this.festmenyek = new ArrayList<>();
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor!= null && sor.equals("")) {
            String[] adatok = sor.split(";");
            festmeny festmeny = new festmeny(adatok[0],adatok[1],adatok[2],0,null,false);
            this.festmenyek.add(festmeny);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }
    public static void licit(boolean elkelt, int licitekSzama, double licitMeret, LocalDateTime legutsoLicit){
        if(elkelt==true){
            System.out.println("Ez a festmény már elkelt!");
        }else if(licitekSzama  == 0){
            licitMeret = 100;
            licitekSzama++;
            legutsoLicit = LocalDateTime.now();
        }else{
            licitMeret = licitMeret*1.1;
            licitekSzama++;
            legutsoLicit = LocalDateTime.now();
        }
    }
    /*public static void licitmeret(boolean elkelt, int licitekSzama, double licitMeret, LocalDateTime legutsoLicit){
        if(elkelt==true){
            System.out.println("Ez a festmény már elkelt!");
        }else if(licitekSzama  == 0){
            licitMeret = 100;
            licitekSzama++;
            legutsoLicit = LocalDateTime.now();
        }else if(menyi > 100 || menyi < 0){
            System.out.println("Nem megfelelő méret csak (0-100) elfogadható!");
        }else{
            licitMeret = licitMeret*1.1;
            licitekSzama++;
            legutsoLicit = LocalDateTime.now();
        }
    }*/
    @Override
    public String toString() {
        String elk = "";
        if(elkelt==true){elk = "elkelt";}else{elk = "nem kelt el";}
        return String.format("%s: %s(%s)\n %s \n %.0f - "+legutsoLicit+" (Összesen: %d db)", festo,cím,stílus,elk,licitMeret,licitekSzama);
    }
}