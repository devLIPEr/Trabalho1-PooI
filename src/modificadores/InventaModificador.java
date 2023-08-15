package modificadores;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Felipe Turetti Peruci
 * @version 1.1
 */
public class InventaModificador implements Modificador{
	private ArrayList<Modificador> modificadores = new ArrayList<Modificador>();
	private int modificadorAtual;
	Random rng = new Random();
	
	/**
	 * @param n Número de letras
	 * @param k Valor somado na cifra de cesar
	 */
	public InventaModificador(int n, int k) {
		this.modificadores.add(new SwapNLetters(n));
		this.modificadores.add(new CaesarCipherForNLetters(n, k));
		this.modificadores.add(new CaesarCipher(n));
		this.modificadorAtual = rng.nextInt(3);
	}
	
	/**
	 * @param palavra A palavra para permutar
	 * @return A palavra com a aplicação do método embaralhar do Modificador selecionado
	 */
	@Override
	public String embaralha(String palavra) {
		return this.modificadores.get(modificadorAtual).embaralha(palavra);
	}
	
	/**
	 * Seleciona um Modificador aleatório
	 */
	public void selectModificador() {
		this.modificadorAtual = rng.nextInt(this.modificadores.size());
	}
	
	/**
	 * @param i O índice do Modificador
	 * Seleciona o Modificador no índice i
	 */
	public void selectModificador(int i) {
		this.modificadorAtual = i;
	}
	
	/**
	 * @return O Modificador atual
	 */
	public Modificador getModificador() {
		return this.modificadores.get(modificadorAtual);
	}
	
	@Override
	public String toString() {
		return this.modificadores.get(modificadorAtual).toString();
	}
	
	/**
	 * @return O nome do método atual
	 */
	public String getMetodo() {
		return this.getModificador().getMetodo();
	}
}
