package main.java;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Bud {
    
    private Bolig bolig;
    private Budgiver budgiver;
    private double pris;
    private LocalDateTime akseptfrist;  //Klokkeslett
    
    
    public Bud(Bolig bolig, Budgiver budgiver, double pris, int timer, int minutter) {  
        this.bolig = bolig;
        this.budgiver = budgiver;
        this.pris = pris;
        this.akseptfrist = LocalDateTime.now().plusHours(timer).plusMinutes(minutter);  //Lager akseptfrist tidspunkt utifra hvor mange timer og minutter det er fra nå.
    }


    //Gettere

    public Bolig getBolig() {
        return bolig;
    }


    public Budgiver getBudgiver() {
        return budgiver;
    }


    public double getPris() {
        return pris;
    }


    public LocalDateTime getAkseptfrist() {
        return akseptfrist;
    }

    public boolean budErAktivt(){
        return akseptfrist.isAfter(LocalDateTime.now());
    }

    public long tidTilFrist(){
        if (!budErAktivt()){
                throw new IllegalStateException("Akseptfristen har gått ut");
        }
        return LocalDateTime.now().until(akseptfrist, ChronoUnit.MINUTES);
    }


    @Override
    public String toString() {
        return "Bud [budgiver=" + budgiver.getNavn() + ", pris=" + pris + ", akseptfrist=" + akseptfrist
                + "]";
    }

    

    


    


}
