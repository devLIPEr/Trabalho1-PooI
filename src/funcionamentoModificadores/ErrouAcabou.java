package funcionamentoModificadores;
import modificadores.InventaModificador;
import modificadores.Modificador;
import palavras.ConjuntoPalavras;

/**
 * @author Felipe Turetti Peruci
 * @version 1.0
 */
public class ErrouAcabou implements FuncionamentoModificador {
	private String nome, descricao, palavraAtual, palavraEmbaralhada;
	private int palavras, tentativas, pontos;
	private InventaModificador modificador = new InventaModificador(2, 5); // 2 letras +5 na cifra
	private ConjuntoPalavras conjuntoPalavras = new ConjuntoPalavras();
	private boolean correta = false;
	
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
	 */
	@Override
	public void tentar(String tentativa) {
		if(tentativas < 1) {
			pontos = 0;
			if(tentativa.equals(palavraAtual)) {
				pontos = tentativa.length();
				System.out.println("Palavra correta!!!");
				correta = true;
			}else {
				for(int i = 0; i < tentativa.length(); i++) {
					if(tentativa.charAt(i) == palavraAtual.charAt(i)) {
						pontos++;
					}
				}
			}
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
				+ "  NumPalavras: %d\n  NumTentativas: %d\n  MaxTentativas: 1\n"
				+ "  TotPontos: %d\n  Modificador: %s\n  PalavraCorreta: %s\n}",
				nome, descricao, palavras, tentativas, pontos, modificador, palavraAtual
		);
	}
}
