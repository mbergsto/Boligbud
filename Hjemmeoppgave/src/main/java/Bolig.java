package main.java;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bolig {

    private String gateadresse;
    private String postnummer;
    private double takstpris;
    private List<Bud> budListe = new ArrayList<>();
    private Bud vinnerbud;
    
    


    public Bolig(String gateadresse, String postnummer, double takstpris) {
        this.gateadresse = gateadresse;
        this.postnummer = postnummer;
        this.takstpris = takstpris;
    }


    public void leggTilBud(Bud bud){
        this.budListe.add(bud);

    }


    public List<Bud> aktiveBudSortert(){
        List<Bud> aktiveBud = new ArrayList<>();
        for (Bud bud : budListe) {
            if (bud.budErAktivt()) {
                aktiveBud.add(bud);
        }
        }

        aktiveBud.sort(Comparator.comparingLong(Bud::tidTilFrist));
        return aktiveBud;

    }

    public Bud høyesteAktiveBud(){
        List <Bud> aktiveBud = aktiveBudSortert();
        if (aktiveBud.isEmpty()){
            throw new IllegalStateException("Det er ingen aktive bud");
        }
        aktiveBud.sort(Comparator.comparingDouble(Bud::getPris));  //Sorterer på pris
        return aktiveBud.get(aktiveBud.size() - 1);
    }

    public void aksepterBudSomVinner(Bud bud) {
        if (budListe.contains(bud) && bud.budErAktivt()) {
            this.vinnerbud = bud;
        } else {
            throw new IllegalArgumentException("Budet er ikke gyldig eller akseptfristen har gått ut.");
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Adresse: ").append(gateadresse).append("\n");
        sb.append("Postnummer: ").append(postnummer).append("\n");
        sb.append("Takstpris: ").append(takstpris).append("\n");

        if (vinnerbud != null) {
            sb.append("Boligen er solgt til ").append(vinnerbud.getBudgiver().getNavn());
            sb.append(" for ").append(vinnerbud.getPris()).append("\n");
        } else {
            sb.append("Boligen er ikke solgt ennå. Aktive bud:\n");
            for (Bud bud : aktiveBudSortert()) {
                sb.append(bud).append("\n");
            }
        }

        return sb.toString();
}



    








}

    

