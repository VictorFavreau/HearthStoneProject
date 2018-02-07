package utils;

public class Tools {

    public static String printHearthStone(){

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

        return stringBuffer.toString();
    }


}
