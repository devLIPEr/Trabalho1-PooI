package base;
import funcionamentoModificadores.InventaFuncionamentoModificador;
import java.util.Scanner;

/**
 * @author Felipe Turetti Peruci
 * @version 1.0
 */
public class ClassePrincipal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tentativa;
		
		InventaFuncionamentoModificador iFM = new InventaFuncionamentoModificador();
		
		iFM.selectFuncionamento();
		System.out.println(iFM.getPalavra());
		while(iFM.podeTentar()) {
			tentativa = scanner.next();
			while(tentativa.length() != iFM.getPalavra().length()) {
				System.out.println("A palavra deve conter a mesma quantidade de letras");
				tentativa = scanner.next();
			}
			iFM.tentar(tentativa);
		}
		System.out.println(iFM.getFuncionamento());
		
		scanner.close();
	}
}
