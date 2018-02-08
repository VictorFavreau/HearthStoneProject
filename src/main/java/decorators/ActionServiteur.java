package decorators;

import actors.Serviteur;

public abstract class ActionServiteur extends Serviteur {

    Serviteur serviteur;

    protected ActionServiteur(){
        super();
    }

    @Override
    public String getNom() {
        return serviteur.getNom();
    }

    @Override
    public String getDescription() {
        return serviteur.getDescription();
    }

    @Override
    public int getMana() {
        return serviteur.getMana();
    }

    @Override
    public int getVie(){ return serviteur.getVie(); }

    @Override
    public int getDegats(){ return serviteur.getDegats(); }

    @Override
    public boolean isSleeping(){ return serviteur.isSleeping(); }

    @Override
    public boolean isProvocation(){ return serviteur.isProvocation(); }

    @Override
    public boolean isVolVie(){ return serviteur.isVolVie(); }


}
