package utils;


import actors.*;
import actors.heros.HerosGuerrier;
import actors.heros.HerosMage;
import actors.heros.HerosPaladin;
import com.sun.deploy.util.StringUtils;
import jeu.Jeu;

import java.util.Scanner;

/**
 * author: Anais BESSON & Victor FAVREAU
 */
public class Tools {

    /**
     * Affiche le logo HearthStone dans le terminal
     */
    public static void printHearthStone(){

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("\n");
        stringBuffer.append("======================================================================\n");
        stringBuffer.append(" _   _                     _    _      _____  _                      \n");
        stringBuffer.append("| | | |                   | |  | |    /  ___|| |                     \n");
        stringBuffer.append("| |_| |  ___   __ _  _ __ | |_ | |__  \\ `--. | |_  ___   _ __    ___ \n");
        stringBuffer.append("|  _  | / _ \\ / _` || '__|| __|| '_ \\  `--. \\| __|/ _ \\ | '_ \\  / _ \\\n");
        stringBuffer.append("| | | ||  __/| (_| || |   | |_ | | | |/\\__/ /| |_| (_) || | | ||  __/\n");
        stringBuffer.append("\\_| |_/ \\___| \\__,_||_|    \\__||_| |_|\\____/  \\__|\\___/ |_| |_| \\___|\n");
        stringBuffer.append("\n");
        stringBuffer.append(" by Anais BESSON & Victor FAVREAU - LP MiAR Alternance\n");
        stringBuffer.append("======================================================================\n");

        log(stringBuffer.toString(), LogType.NORMAL);
    }

    /**
     * Retourne l'action saisie par l'utilisateur
     * @return InputType saisi
     */
    public static InputType getInputType(){

        InputType inputType = InputType.INVALIDE;
        StringBuilder message = new StringBuilder("Que souhaitez vous faire ?\n");
        message.append("(P) POSER CARTE, (A) ATTAQUER, (F) PASSER TOUR, (Q) QUITTER");

        String str = readInput(message.toString());

        while(inputType == InputType.INVALIDE){
            switch(str.toUpperCase()){

                case "Q":
                    inputType = InputType.QUITTER;
                    break;

                case "A":
                    inputType = InputType.ATTAQUER;
                    break;

                case "P":
                    inputType = InputType.POSER;
                    break;

                case "F":
                    inputType = InputType.FIN_TOUR;
                    break;



                default:
                    log("Bien tenté, mais il m'est impossible d'effectuer l'action "+ str.toUpperCase() + " désolé... Recommencez !", LogType.WARNING);
                    break;
            }
        }

        return inputType;
    }

    public static TypeActeur getTypeCible(){

        TypeActeur cible = TypeActeur.INVALIDE;
        String message = "Que ciblez vous ? (H) HEROS, (S) SERVITEUR";

        String str = readInput(message);

        while(cible == TypeActeur.INVALIDE || cible == TypeActeur.SORT){

            switch(str.toUpperCase()){
                case "H":
                    cible = TypeActeur.HEROS;
                    break;

                case "S":
                    cible = TypeActeur.SERVITEUR;
                    break;

                default:
                    log("Oops, vous ne pouvez pas viser un " + str.toUpperCase() +" ! Did it again...", LogType.WARNING);
                    break;
            }
        }

        return cible;
    }

    public static TypeClasse getClasse(Player player){

        TypeClasse classe = TypeClasse.NEUTRE;
        StringBuilder msg = new StringBuilder("Choisir la classe du " + player + "\n");
        msg.append("(M) Mage, Effet: Inflige un point de dégâts à un adversaire (Serviteur ou Heros)\n");
        msg.append("(P) Paladin, Effet: Invoque un serviteur 'Recrue de la main d'argent' 1:1\n");
        msg.append("(G) Guerrier, Effet: Confère 2 points d'armure au Heros");



        while(classe == TypeClasse.NEUTRE){

            String str = readInput(msg.toString());

            switch(str.toUpperCase()){
                case "M":
                    classe = TypeClasse.MAGE;
                    break;

                case "P":
                    classe = TypeClasse.PALADIN;
                    break;

                case "G":
                    classe = TypeClasse.GUERRIER;
                    break;

                default:
                    log("Sans vouloir vous vexer, il me semble que le Heros: " + str.toUpperCase() +" n'existe pas. Un petit effort !", LogType.WARNING);
                    break;
            }
        }

        return classe;
    }

    /**
     * Fonction permettant de recupérer l'entree clavier saisie par l'utilisateur
     * @param msg message à afficher avant la saisie
     * @return message saisi
     */
    public static String readInput(String msg){
        Scanner sc = new Scanner(System.in);
        log(msg, LogType.INFO);
        String str = sc.nextLine();

        return str;
    }



    /**
     * Retourne la valeur numerique saisie par l'utilisateur
     * @param msg message à afficher
     * @return valeur numerique saisie
     */
    public static Integer readIntegerValue(String msg){

        boolean isInteger = false;
        int value = -1;

        while(!isInteger){

            Scanner sc = new Scanner(System.in);
            log(msg, LogType.INFO);
            String str = sc.nextLine();

            if(!str.equals("")){
                isInteger = str.chars().allMatch( Character::isDigit);

                if(isInteger){
                    value = Integer.parseInt(str);
                } else {
                    log("Veuillez saisir une valeur valide !", LogType.WARNING);
                }
            }

        }

        return value;
    }

    /**
     * Retourne l'indice sur le plateau du joueur du serviteur saisi
     * @param joueur joueur concerné
     * @return Valeur sur le plateau du serviteur saisi
     */
    public static Serviteur readServiteur(Player joueur){

        boolean valide = false;
        int value;
        Serviteur serviteur = null;
        StringBuilder msg = new StringBuilder("Saisir le code du serviteur: \n");
        String msgErreur = "Oops, il semblerait que le serviteur n'existe pas...";

        Jeu.getPlateau().affichePlateauJoueur(joueur);

        while(!valide){

            switch(joueur){

                case JOUEUR1:
                    value = readIntegerValue(msg.toString());

                    if(value >= 0 && value < Jeu.getPlateau().getCartesJ1().size()){
                        valide = true;
                        serviteur = Jeu.getPlateau().getCarteJ1(value);
                    } else {
                        log(msgErreur, LogType.WARNING);
                    }

                    break;

                case JOUEUR2:
                    value = readIntegerValue(msg.toString());

                    if(value >= 0 && value < Jeu.getPlateau().getCartesJ2().size()){
                        valide = true;
                        serviteur = Jeu.getPlateau().getCarteJ2(value);
                    } else {
                        log(msgErreur, LogType.WARNING);
                    }

                    break;
            }
        }

        return serviteur;
    }

    /**
     * Retourne le joueur saisie par l'utilisateur
     * @return joueur saisi
     */
    public static Player readPlayer(String msg){

        boolean valide = false;
        Player player = null;
        int value;

        if(msg.equals("")){
            String msgDefault = "Selectionnez le joueur: \n";
        }

        msg += "(1) JOUEUR1, (2) JOUEUR2";

        String msgErreur = "Oups, il semblerait que le joueur n'existe pas...";

        while(!valide){

            value = readIntegerValue(msg);

            switch(value){
                case 1:
                    valide = true;
                    player = Player.JOUEUR1;
                    break;

                case 2:
                    valide = true;
                    player = Player.JOUEUR2;
                    break;

                default:
                    log(msgErreur, LogType.WARNING);
                    break;
            }
        }

        return player;

    }

    public static LogType getLogPlayer(Player player){
        switch(player){
            case JOUEUR1:
                return LogType.JOUEUR1;

            case JOUEUR2:
                return LogType.JOUEUR2;

            default:
                return LogType.NORMAL;
        }
    }

    /**
     * Formatteur de message
     * @param msg message à afficher
     * @param logType type de message
     */
    public static void log(String msg, LogType logType){

        String prefixe;

        switch(logType){
            case INFO:
                prefixe = ">>> ";
                break;

            case WARNING:
                prefixe = "!!! ";
                break;

            case JOUEUR1:
                prefixe = "JOUEUR 1: ";
                break;

            case JOUEUR2:
                prefixe = "JOUEUR 2: ";
                break;

            default:
                prefixe = "";
                break;
        }

        System.out.println(prefixe + msg );

    }

    public static Player getAdversaire(Player player){
        if(player == Player.JOUEUR1){
            return Player.JOUEUR2;
        } else {
            return Player.JOUEUR2;
        }
    }

    public static void finJeu(){
        if(Jeu.getJoueur1().isDead()){
            log("Le joueur "+Player.JOUEUR2+" a gagné la partie.", LogType.WARNING);
        } else if (Jeu.getJoueur2().isDead()) {
            log("Le joueur "+Player.JOUEUR1+" a gagné la partie.", LogType.WARNING);
        } else {
            log("Merci d'avoir joué !", LogType.INFO);
        }
    }

    public static InputType getInputMenu(){

        InputType inputType = InputType.INVALIDE;
        StringBuilder message = new StringBuilder("Que souhaitez vous faire ?\n");
        message.append("(J) JOUER, (H) AIDE, (Q) QUITTER");

        String str = readInput(message.toString());

        while(inputType == InputType.INVALIDE){
            switch(str.toUpperCase()){

                case "J":
                    inputType = InputType.JOUER;
                    break;

                case "Q":
                    inputType = InputType.QUITTER;
                    break;

                case "H":
                    inputType = InputType.HELP;
                    break;

                default:
                    log("Bien tenté, mais il m'est impossible d'effectuer l'action "+ str.toUpperCase() + " désolé... Recommencez !", LogType.WARNING);
                    break;
            }
        }

        return inputType;



    }



}
