package palavras;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Felipe Turetti Peruci
 * @version 1.1
 */
public class ConjuntoPalavras {
	private static ArrayList<String> listaDePalavras = new ArrayList<String>(
			Arrays.asList(
					"propriedade",
					"escavar",
					"grato",
					"conjunto",
					"contorcer",
					"palavra",
					"merecer",
					"tolerar",
					"filhos",
					"cativar",
					"tentativa",
					"modificador",
					"funcionamento",
					"comando",
					"correta"
					)
			);
	private static Random rng = new Random();
	
	/**
	 * @return Uma palavra aleatória dentro do conjunto
	 */
	public static String getRandomWord() {
		return listaDePalavras.get(rng.nextInt(listaDePalavras.size()));
	}
}
