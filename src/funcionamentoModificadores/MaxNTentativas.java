package funcionamentoModificadores;
import base.UserInterface;
import modificadores.*;
import palavras.*;
import base.ConsoleColors;
import base.UserInterface;
import exceptions.*;

/**
 * @author Felipe Turetti Peruci
 * @author Marcos Vinicius Procykevicz
 * @version 1.2
 */
public class MaxNTentativas implements FuncionamentoModificador {
	private String nome, descricao, palavraAtual, palavraEmbaralhada;
	private int tentativas, pontos, n;
	private InventaModificador modificador = new InventaModificador(3, 2); // 3 letras +2 na cifra
	private boolean correta = false;
	
	/**
	 * Checa se o usuário pode fazer uma tentativa
	 * @return Um valor booleano que indica se o usuário pode fazer uma tentativa
	 */
	@Override
	public boolean podeTentar() {
		return (correta) ? false : (tentativas < n);
	}
	
	/**
	 * @param n Número máximo de tentativas
	 */
	public MaxNTentativas(int n) {
		this.n = n;
		this.nome = String.format("Max %d Tentativas", n);
		this.descricao = String.format(" O jogador terá %d tentativas para adivinhar a palavra", n);
	}

	/**
	 * Compara a tentativa do usuário com a palavra correta e atribui pontos
	 * @param tentativa Palavra que o usuário advinhou
	 * @throws palavraLengthException 
	 */
	@Override
	public void tentar(String tentativa) throws palavraLengthException {
		if(tentativa.length() != palavraAtual.length()) {
			throw new palavraLengthException();
		}
		if(tentativas < n) {
			tentativas++;
			int pontosTentativa = 0;
			if(tentativa.equals(palavraAtual)) {
				pontosTentativa = tentativa.length();
				UserInterface.correta();
				correta = true;
			}else {
				for(int i = 0; i < tentativa.length(); i++) {
					if(tentativa.charAt(i) == palavraAtual.charAt(i)) {
						pontosTentativa++;
					}
				}
			}
			pontos = Math.max(pontos, pontosTentativa);
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
				+ "\n  MaxTentativas: " + ConsoleColors.RED_BOLD_BRIGHT + "%d" + ConsoleColors.RESET
				+ "\n  TotPontos: " + ConsoleColors.GREEN_BOLD_BRIGHT + "%d" + ConsoleColors.RESET
				+ "\n  Modificador: " + ConsoleColors.CYAN_BRIGHT + "%s" + ConsoleColors.RESET
				+ "\n  PalavraCorreta: " + ConsoleColors.GREEN_BRIGHT + "%s" + ConsoleColors.RESET + "\n}",
				nome, descricao, tentativas, n, pontos, modificador, palavraAtual
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

	public String getDescricao(){
		return this.descricao;
	}

	public int getLimite(){
		return this.n;
	}

	public int getTentativas(){
		return this.tentativas;
	}

	public int getPontos(){
		return this.pontos;
	}
}