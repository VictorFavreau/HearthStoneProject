package jeu;

public class Jeu {

    private static Plateau plateau;
    private static Joueur joueur1;
    private static Joueur joueur2;

    public Jeu(){
        init();
    }

    public void init(){
        plateau = new Plateau();
        joueur1 = new Joueur();
        joueur2 = new Joueur();
    }

    public static Plateau getPlateau() {
        return plateau;
    }

    public static Joueur getJoueur1(){
        return joueur1;
    }

    public static Joueur getJoueur2(){
        return joueur2;
    }
}
