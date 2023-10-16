package main.java;
public class Budgiver {
    
    private String navn;
    private String tlf;

    


    public Budgiver(String navn, String tlf) {
        this.navn = navn;
        this.tlf = tlf;
    }




    public void opprettBud(Bolig bolig, double pris, int timer, int minutter){
        Bud bud = new Bud(bolig, this, pris, timer, minutter);
        bolig.leggTilBud(bud);
    }

    



    public String getNavn() {
        return navn;
    }




    public String getTlf() {
        return tlf;
    }


}

