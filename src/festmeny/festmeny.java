package festmeny;
import java.time.LocalDateTime;

public class festmeny {
    private String cím;
    private String festo;
    private String stílus;   
    private int licitekSzama;
    private double licitMeret;
    private LocalDateTime legutsoLicit;
    private boolean elkelt;

    public festmeny() {
        this.cím = "";
        this.festo = "";
        this.stílus = "";
        this.licitekSzama = 0;    
        this.legutsoLicit = null;
        this.elkelt = false;
    }

    public festmeny(String cím, String festo, String stílus) {
        this.cím = cím;
        this.festo = festo;
        this.stílus = stílus;
        this.licitekSzama = 0;
        this.legutsoLicit = null;
        this.elkelt = false;
    }

    public void licit(){
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
    public void licitmeret(int mennyi){
        if(elkelt==true){
            System.out.println("Ez a festmény már elkelt!");
        }else if(licitekSzama  == 0){
            licitMeret = 100;
            licitekSzama++;
            legutsoLicit = LocalDateTime.now();
        }else if(mennyi > 100 || mennyi < 0){
            System.out.println("Nem megfelelő méret csak (0-100) elfogadható!");
        }else{
            licitMeret = licitMeret*1.1;
            licitekSzama++;
            legutsoLicit = LocalDateTime.now();
        }
    }
    @Override
    public String toString() {
        /*String elk = "";
        if(elkelt==true){elk = "elkelt";}else{elk = "nem kelt el";}
        return String.format("%s: %s(%s)\n %s \n %.0f - "+legutsoLicit+" (Összesen: %d db)", festo,cím,stílus,elk,licitMeret,licitekSzama);*/
        return String.format("\n\n%s: %s(%s)\n%b\nLegmagasabb licit: %.0f - "+legutsoLicit+" (összesen: %d db)",festo,cím,stílus,elkelt,licitMeret,licitekSzama);
    }
}