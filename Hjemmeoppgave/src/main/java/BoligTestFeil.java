package main.java;

public class BoligTestFeil {
    
    public static void main(String[] args) {
        // Opprett boliger
        Bolig bolig1 = new Bolig("Gate 1", "1234", 2000000);
        Bolig bolig2 = new Bolig("Gate 2", "5678", 2500000);
        
        // Opprett budgivere
        Budgiver budgiver1 = new Budgiver("Ola", "12345678");
        Budgiver budgiver2 = new Budgiver("Kari", "87654321");
        Budgiver budgiver3 = new Budgiver("Hans", "43215678");

        //Oppretter bud

        Bud bud1 = new Bud(bolig2, budgiver3, 2000000, 1, 0);

        //Prøver å akseptere bud på bolig2 som vinner for bolig 1
        System.out.println("Forventer at budet ikke aksepteres som vinnerbud og feilmelding kastes");
        bolig1.aksepterBudSomVinner(bud1);

    }
}
