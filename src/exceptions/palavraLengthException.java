package exceptions;

/**
 * @author Felipe Turetti Peruci
 * @version 1.0
 */
public class palavraLengthException extends Exception {
	@Override
	public String toString() {
		return "O tamanho da tentativa deve ser do mesmo tamanho da palavra";
	}
}
