package funcionamentoModificadores;
import modificadores.InventaModificador;
import palavras.ConjuntoPalavras;
import base.ConsoleColors;
import exceptions.*;

/**
 * @author Felipe Turetti Peruci
 * @version 1.1
 */
public class ErrouAcabou implements FuncionamentoModificador {
	private String nome, descricao, palavraAtual, palavraEmbaralhada;
	private int tentativas, pontos;
	private InventaModificador modificador = new InventaModificador(2, 5); // 2 letras +5 na cifra
	private boolean correta = false;
	
	/**
	 * O usuário terá 1 tentativa para adivinhar a palavra
	 */
	public ErrouAcabou() {
		this.nome = "ErrouAcabou";
		this.descricao = "O usuário terá 1 tentativa para adivinhar a palavra";
	}
	
	/**
	 * @return Um valor booleano que indica se o usuário pode fazer uma tentativa
	 */
	@Override
	public boolean podeTentar() {
		return (correta) ? false : (tentativas < 1);
	}
	
	/**
	 * @param tentativa Palavra que o usuário advinhou
	 * @throws palavraLengthException 
	 */
	@Override
	public void tentar(String tentativa) throws palavraLengthException {
		if(tentativa.length() != palavraAtual.length()) {
			throw new palavraLengthException();
		}
		if(tentativas < 1) {
			tentativas++;
			pontos = 0;
			if(tentativa.equals(palavraAtual)) {
				pontos = tentativa.length();
				System.out.println(ConsoleColors.GREEN_BRIGHT + "Palavra correta!!!" + ConsoleColors.RESET);
				correta = true;
			}else {
				for(int i = 0; i < tentativa.length(); i++) {
					if(tentativa.charAt(i) == palavraAtual.charAt(i)) {
						pontos++;
					}
				}
			}
		}
	}

	/**
	 * Seleciona uma palavra alearória e então embaralha ela
	 */
	@Override
	public void setPalavra() {
		this.palavraAtual = ConjuntoPalavras.getRandomWord();
		this.palavraEmbaralhada = modificador.embaralha(this.palavraAtual);
	}

	/**
	 * @return A palavra atual após a aplicação do método de embaralhamento
	 */
	@Override
	public String getPalavra() {
		return this.palavraEmbaralhada;
	}

	@Override
	public String toString() {
		return String.format(
				"{\n  Nome: " + ConsoleColors.CYAN_BRIGHT + "%s" + ConsoleColors.RESET
				+ "\n  Descrição: " + "%s"
				+ "\n  NumTentativas: " + ConsoleColors.GREEN_BOLD_BRIGHT + "%d" + ConsoleColors.RESET
				+ "\n  MaxTentativas: " + ConsoleColors.RED_BOLD_BRIGHT + "1" + ConsoleColors.RESET
				+ "\n  TotPontos: " + ConsoleColors.GREEN_BOLD_BRIGHT + "%d" + ConsoleColors.RESET
				+ "\n  Modificador: " + ConsoleColors.CYAN_BRIGHT + "%s" + ConsoleColors.RESET
				+ "\n  PalavraCorreta: " + ConsoleColors.GREEN_BRIGHT + "%s" + ConsoleColors.RESET + "\n}",
				nome, descricao, tentativas, pontos, modificador, palavraAtual
		);
	}
	
	/**
	 * @return Modificador atual
	 */
	public String getModificador() {
		return modificador.getMetodo();
	}
	
	/**
	 * @return Funcionamento atual
	 */
	public String getFuncionamento() {
		return nome;
	}
}
