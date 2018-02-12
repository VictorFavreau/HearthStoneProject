package actors;

/**
 * author: Anais BESSON & Victor FAVREAU
 */
public abstract class Acteur {

    protected TypeActeur typeActeur;
    protected int vie;

    public Acteur(){

    }

    /**
     * Le serviteur est il mort ?
     * @return true si le serviteur n'as plus de défense, false sinon
     */
    public boolean isDead(){
        return this.getVie() <= 0;
    }

    /**
     * GETTERS
     */

    public int getVie() {
        return vie;
    }

    public TypeActeur getTypeActeur() {
        return typeActeur;
    }
}
