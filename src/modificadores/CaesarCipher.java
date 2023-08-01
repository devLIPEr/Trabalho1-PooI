package modificadores;

/**
 * @author Felipe Turetti Peruci
 * @version 1.0
 */
public class CaesarCipher implements Modificador {
	private int k;
	
	/**
	 * @param k Quantidade que será somada a palavra
	 */
	public CaesarCipher(int k) {
		this.k = k;
	}

	/**
	 * @param palavra A palavra para aplicar a cifra
	 * @return A palavra com N letras com a cifra aplicada
	 */
	@Override
	public String embaralha(String palavra) {
		char[] word = palavra.toCharArray();
		
		for(int i = 0; i < word.length; i++) {
			if(word[i]+k <= 'z') {				
				word[i] += this.k; // add k to a letter
			}else {
				int resto = 'z'-word[i]+k;
				word[i] = (char)('a'+resto);
			}
		}
		
		return new String(word);
	}

	@Override
	public String toString() {
		return String.format("CaesarCipher%dValores", k);
	}
}
