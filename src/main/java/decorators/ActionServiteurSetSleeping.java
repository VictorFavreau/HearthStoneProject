package decorators;

/**
 * @author: Anais BESSON et Victor FAVREAU
 */
public class ActionServiteurSetSleeping extends ActionServiteur {

    private boolean sleeping;

    public ActionServiteurSetSleeping(boolean sleeping){
        super();
        this.sleeping = sleeping;
    }

    @Override
    public boolean isSleeping() {
        return sleeping;
    }
}
