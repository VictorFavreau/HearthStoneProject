package actors;

/**
 * author: Anais BESSON & Victor FAVREAU
 */
public abstract class Serviteur extends Carte{


    protected int degats;
    protected boolean sleeping;
    protected boolean provocation;
    protected boolean volVie;


    public Serviteur(){
        super();
    }

    /**
     * GETTERS
     */

    public int getDegats() {
        return degats;
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public boolean isProvocation() {
        return provocation;
    }

    public boolean isVolVie() {
        return volVie;
    }

}
