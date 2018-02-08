package actors;

public abstract class Carte extends Acteur{

    protected String nom;
    protected String description;
    protected int mana;
    protected TypeClasse typeCarte;

    public Carte(){

    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getMana() {
        return mana;
    }

    public TypeClasse getTypeCarte() {
        return typeCarte;
    }
}
