package utils;

import jdk.internal.util.xml.impl.Input;

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
     * @param msg message à afficher avant la saisie
     * @return InputType saisi
     */
    public static InputType getInputType(String msg){

        InputType inputType = InputType.INVALIDE;
        String str = readInput(msg);

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
                inputType = InputType.INVALIDE;
                break;
        }

        return inputType;
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

        System.out.println(prefixe + msg);

    }
}
