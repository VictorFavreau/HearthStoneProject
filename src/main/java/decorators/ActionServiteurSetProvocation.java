package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionServiteurSetProvocation extends ActionServiteur{

    private boolean provocation;

    public ActionServiteurSetProvocation(boolean provocation){
        super();
        this.provocation = provocation;
    }

    public boolean isProvocation() {
        return provocation;
    }
}
