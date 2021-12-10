package com.overshade.sportsappexam;

public class Entrenament {
    private String nom;
    private String descripcio;
    private int imatge;

    public static final Entrenament[] entrenaments = {
            new Entrenament("Extremitats a Tope",
                    "5 Flexions a terra\n" +
                            "10 Inclinacions d'una cama\n" +
                            "15 Flexions dorsals\n",
                             R.drawable.running),
            new Entrenament("Agonia Màxima",
                    "100 Flexions inclinades\n" +
                            "100 Flexions\n" +
                            "100 Abdominals\n" +
                            "100 Esquats\n",
                             R.drawable.force),
            new Entrenament("Entrenament especial",
                    "5 Dorsals\n" +
                            "10 Flexions\n" +
                            "15 Esquats\n",
                             R.drawable.football),
            new Entrenament("Força i longitud",
                    "500 Metres màxima velocitat\n" +
                            "21 Llançaments de pes \n" +
                            "21 Flexions\n",
                             R.drawable.yoga)
    };


    private Entrenament(String nom, String descripcio, int imatge) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.imatge = imatge;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return this.nom;
    }

    public int getImatge() {
        return this.imatge;
    }
}
