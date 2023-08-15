package modificadores;
import java.util.Random;

/**
 * @author Felipe Turetti Peruci
 * @version 1.1
 */
public class SwapNLetters implements Modificador {
	private Random rng = new Random();
	private int n;
	
	/**
	 * @param n Número de letras para trocar
	 */
	public SwapNLetters(int n) {
		this.n = n;
	}

	/**
	 * @param palavra A palavra para permutar
	 * @return A palavra com N permutações
	 */
	@Override
	public String embaralha(String palavra) {
		char[] word = palavra.toCharArray();
		
		for(int i = 0; i < n; i++) {
			int p1 = rng.nextInt(palavra.length());
			int p2 = rng.nextInt(palavra.length());
			
			while(p1 == p2) {
				p2 = rng.nextInt(palavra.length());
			}
			
			char aux = word[p1];
			word[p1] = word[p2];
			word[p2] = aux;
		}
		
		return new String(word);
	}

	@Override
	public String toString() {
		return String.format("Troca %d letras", n);
	}

	/**
	 * @return O nome do método utilizado
	 */
	public String getMetodo() {
		return "Troca letras";
	}
}
