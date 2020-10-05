package com.company;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




public class Main {

    public static void loadData (ArrayList<String> liste) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("personnes.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                liste.add(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveData (ArrayList<String>liste ) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("personnes.txt", false));

            for (int i = 0; i < liste.size(); ++i) {
                writer.write(liste.get(i));
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        ArrayList<String> personnes = new ArrayList <String> ();

        loadData(personnes);

        Scanner scanner = new Scanner (System.in);

        while (true) {

            System.out.println ("Que voulez vous faire ?");

            String commande = scanner.nextLine();

            if (commande.equals("exit")) {
                System.out.println("au revoir!");
                break;
            }

            String[] mots = commande.split(" ");

            switch (mots[0])
            {
                case "listpersons":
                    System.out.println("===");
                    System.out.println("Voici la liste des personnes:");
                    System.out.println("===");
                    for (String p:personnes)
                        System.out.println(p);
                    break;

                case "addperson":
                    personnes.add(mots[1]);
                    break;

                default:
                    System.out.println("mauvaise commande");
                    break;
            }
        }
        scanner.close();
        saveData(personnes);
    }
}
