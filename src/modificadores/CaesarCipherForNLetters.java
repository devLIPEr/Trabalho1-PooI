package modificadores;
import java.util.Random;

public class CaesarCipherForNLetters implements Modificador {
	private Random rng = new Random();
	private int n, k;
	
	/**
	 * @param n Quantidade de letras que serão alteradas
	 * @param k Quantidade que será somada a letra selecionada
	 */
	public CaesarCipherForNLetters(int n, int k) {
		this.n = n;
		this.k = k;
	}

	/**
	 * @param palavra A palavra para aplicar a cifra
	 * @return A palavra com N letras com a cifra aplicada
	 */
	@Override
	public String embaralha(String palavra) {
		char[] word = palavra.toCharArray();
		
		for(int i = 0; i < n; i++) {
			int p1 = rng.nextInt(palavra.length());
			
			if(word[p1]+k <= 'z') {				
				word[p1] += this.k;
			}else {
				int resto = 'z'-word[p1]+k;
				word[p1] = (char)('a'+resto);
			}
		}
		
		return new String(word);
	}

	@Override
	public String toString() {
		return String.format("CaesarCipherFor%dLetters%dValores", n, k);
	}
}
