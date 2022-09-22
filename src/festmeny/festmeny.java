package festmeny;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class festmeny {
    private String cím;
    private String festo;
    private String stílus;   
    private int licitekSzama;
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

    public festmeny(String cím, String festo, String stílus, int licitekSzama, LocalDateTime legutsoLicit,
            boolean elkelt) {
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
}