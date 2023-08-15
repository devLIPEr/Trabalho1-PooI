package base;
import funcionamentoModificadores.InventaFuncionamentoModificador;
import java.util.Scanner;
import exceptions.*;

/**
 * @author Felipe Turetti Peruci
 * @author Marcos Vinicius Procykevicz
 * @version 1.2
 */

public class ClassePrincipal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tentativa;
		
		InventaFuncionamentoModificador iFM = new InventaFuncionamentoModificador();
		
		iFM.selectFuncionamento();

		UserInterface.intro();
		UserInterface.funcionamento(iFM.getNomeFuncionamento());
		UserInterface.print(iFM.getDescricao());
		UserInterface.modificador(iFM.getModificador());
		UserInterface.introTxt();

		while(iFM.podeTentar()) {
			try {
				UserInterface.palavra(iFM.getPalavra());
				UserInterface.printChances(iFM.getQuantidadeTentativa(), iFM.getQuantidadeLimite(), iFM.getQuantidadePontos());
				UserInterface.chance();
				tentativa = scanner.next();
				iFM.tentar(tentativa);
			}catch(palavraLengthException e) {
				System.out.println(e);
			}
		}
		
		System.out.println(iFM);
		
		scanner.close();
	}
}