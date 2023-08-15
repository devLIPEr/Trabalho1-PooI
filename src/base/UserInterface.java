package base;

/**
 * @author Marcos Vinicius Procykevicz
 * @version 1.0
 */
public class UserInterface {

    public static void intro(){
        System.out.println(ConsoleColors.YELLOW_BOLD + "#####################################################");
        System.out.println("#***************************************************#");
        System.out.println("#           " + ConsoleColors.BLUE_BOLD_BRIGHT + "ADIVINHE A PALAVRA CORRETA" + ConsoleColors.YELLOW_BOLD + "              #");
        System.out.println("#***************************************************#");
        System.out.println("#####################################################" + ConsoleColors.RESET);
        System.out.println();
    }

    public static void funcionamento(String funcionamento){
        System.out.println(ConsoleColors.YELLOW_BOLD + "Funcionamento: " + funcionamento + ConsoleColors.RESET);
    }

    public static void modificador(String modificador){
        System.out.println(ConsoleColors.YELLOW_BOLD + "Modificador: " + modificador + ConsoleColors.RESET);
    }

    public static void introTxt(){
        System.out.println(ConsoleColors.YELLOW_BOLD + "\nA SEGUINTE PALAVRA ESTÁ EMBARALHADA. \nDECIFRE-A...\n" + ConsoleColors.RESET);
    }

    public static void palavra(String palavra){
        System.out.println(ConsoleColors.YELLOW_BOLD + "----------------" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + " " + palavra + ConsoleColors.RESET);
        //System.out.println(ConsoleColors.YELLOW_BOLD + "----------------" + ConsoleColors.RESET);
    }

    public static void printChances(int tentativas, int limite, int pontos){
        tentativas = tentativas+1;
        System.out.println(ConsoleColors.YELLOW_BOLD + "----------------" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + " Tentativa: " + tentativas + "º");
        System.out.println(" Limite: " + limite);
        System.out.println(" Pontos: " + pontos + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BOLD + "----------------" + ConsoleColors.RESET);
    }

    public static void chance(){
        System.out.print("-> ");
    }
    public static void correta(){
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\n#####################");
        System.out.println(" Palavra correta!!!");
        System.out.println("#####################\n" + ConsoleColors.RESET);
    }

    public static void print(String frase){
        System.out.println(frase);
    }

}