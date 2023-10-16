package main.java;

public class BoligTestProgram {

    public static void main(String[] args) {
        // Opprett boliger
        Bolig bolig1 = new Bolig("Gate 1", "1234", 2000000);
        Bolig bolig2 = new Bolig("Gate 2", "5678", 2500000);
        
        // Opprett budgivere
        Budgiver budgiver1 = new Budgiver("Ola", "12345678");
        Budgiver budgiver2 = new Budgiver("Kari", "87654321");
        Budgiver budgiver3 = new Budgiver("Hans", "43215678");
        
        // Budgivere byr på boliger
        budgiver1.opprettBud(bolig1, 2100000, 2, 30);
        budgiver2.opprettBud(bolig1, 2150000, 3, 0);
        budgiver1.opprettBud(bolig2, 2550000, 1, 30);
        budgiver3.opprettBud(bolig1, 3000000, 1, 0);
        
        // Vis alle bud på en bolig
        System.out.println("Bud på bolig1:");
        for (Bud bud : bolig1.aktiveBudSortert()) {
            System.out.println(bud);
        }
        
        System.out.println("\nBud på bolig2:");
        for (Bud bud : bolig2.aktiveBudSortert()) {
            System.out.println(bud);
        }
        
        
        // Aksepter et bud som vinnerbud (f.eks. det høyeste budet på bolig 1)
        bolig1.aksepterBudSomVinner(bolig1.høyesteAktiveBud());
        
        // Skriv ut en string-representasjon av boligene
        System.out.println("\n" + bolig1);
        System.out.println(bolig2);
    }

    
}

