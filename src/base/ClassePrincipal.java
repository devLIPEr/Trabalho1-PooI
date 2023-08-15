package base;
import funcionamentoModificadores.InventaFuncionamentoModificador;
import java.util.Scanner;
import exceptions.*;

/**
 * @author Felipe Turetti Peruci
 * @version 1.1
 */
public class ClassePrincipal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tentativa;
		
		InventaFuncionamentoModificador iFM = new InventaFuncionamentoModificador();
		
		iFM.selectFuncionamento();
		
		System.out.println("Funcionamento: " + iFM.getNomeFuncionamento());
		System.out.println("Modificador: " + iFM.getModificador());
		System.out.println(iFM.getPalavra());
		
		while(iFM.podeTentar()) {
			try {
				tentativa = scanner.next();
				iFM.tentar(tentativa);
			}catch(palavraLengthException e) {
				System.out.println(ConsoleColors.RED_BRIGHT + e + ConsoleColors.RESET);
			}
		}
		
		System.out.println(iFM);
		
		scanner.close();
	}
}
