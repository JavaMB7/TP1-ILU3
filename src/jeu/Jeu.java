package jeu;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

import java.util.Arrays;
import java.util.List;

public class Jeu {
    private Sabot sabot;

    public Jeu() {

        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Carte[] cartes = jeuDeCartes.donnerCartes();

        List<Carte> listeCartes = Arrays.asList(cartes);
        List<Carte> cartesMelangees = GestionCartes.melanger(listeCartes);

        sabot = new Sabot(cartesMelangees.toArray(new Carte[0]));
    }

    public Sabot getSabot() {
        return sabot;
    }

}