package palavras;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Felipe Turetti Peruci
 * @version 1.0
 */
public class ConjuntoPalavras {
	private ArrayList<String> listaDePalavras = new ArrayList<String>();
	private Random rng = new Random();

	public ConjuntoPalavras(){
		listaDePalavras.add("propriedade");
		listaDePalavras.add("escavar");
		listaDePalavras.add("grato");
		listaDePalavras.add("conjunto");
		listaDePalavras.add("palavra");
		listaDePalavras.add("contorcer");
		listaDePalavras.add("merecer");
		listaDePalavras.add("tolerar");
		listaDePalavras.add("cativar");
		listaDePalavras.add("filhos");
	}
	
	/**
	 * @return Uma palavra aleatória dentro do conjunto
	 */
	public String getRandomWord() {
		return listaDePalavras.get(rng.nextInt(listaDePalavras.size()));
	}
}
