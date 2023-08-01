package funcionamentoModificadores;
import modificadores.*;
import palavras.*;

/**
 * @author Felipe Turetti Peruci
 * @version 1.0
 */
public class MaxNTentativas implements FuncionamentoModificador {
	private String nome, descricao, palavraAtual, palavraEmbaralhada;
	private int palavras, tentativas, pontos, n;
	private Modificador modificador = new InventaModificador(3, 2); // 3 letras +2 na cifra
	private ConjuntoPalavras conjuntoPalavras = new ConjuntoPalavras();
	private boolean correta = false;
	
	/**
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
		this.nome = String.format("Max%dTentativas", n);
		this.descricao = String.format("O usuário terá %d tentativas para adivinhar a palavra", n);
	}

	/**
	 * @param tentativa Palavra que o usuário advinhou
	 */
	@Override
	public void tentar(String tentativa) {
		if(tentativas < n) {
			int pontosTentativa = 0;
			if(tentativa.equals(palavraAtual)) {
				pontosTentativa = tentativa.length();
				System.out.println("Palavra correta!!!");
				correta = true;
			}else {
				for(int i = 0; i < tentativa.length(); i++) {
					if(tentativa.charAt(i) == palavraAtual.charAt(i)) {
						pontosTentativa++;
					}
				}
			}
			pontos = Math.max(pontos, pontosTentativa);
			tentativas++;
		}
	}

	/**
	 * Seleciona uma palavra alearória e então embaralha ela
	 */
	@Override
	public void setPalavra() {
		this.palavraAtual = conjuntoPalavras.getRandomWord();
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
				"{\n  Nome: %s\n  Descrição: %s\n"
				+ "  NumPalavras: %d\n  NumTentativas: %d\n  MaxTentativas: %d\n"
				+ "  TotPontos: %d\n  Modificador: %s\n  PalavraCorreta: %s\n}",
				nome, descricao, palavras, tentativas, n, pontos, modificador, palavraAtual
		);
	}
}
