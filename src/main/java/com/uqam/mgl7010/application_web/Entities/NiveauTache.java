package com.uqam.mgl7010.application_web.Entities;

// Enum pour le niveau de la tâche avec valeurs associées
public enum NiveauTache {
    BASIC(10), MEDIUM(20), PROFESSIONNEL(50);

    private final int valeur;

    NiveauTache(int valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }
}