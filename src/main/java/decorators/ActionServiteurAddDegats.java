package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionServiteurAddDegats extends ActionServiteur {

    private int degats;

    public ActionServiteurAddDegats(int degats){
        super();
        this.degats = degats;
    }

    @Override
    public int getDegats() {
        return serviteur.getDegats() + degats;
    }
}
