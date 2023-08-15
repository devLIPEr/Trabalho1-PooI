package funcionamentoModificadores;
import java.util.ArrayList;
import java.util.Random;
import base.ConsoleColors;
import exceptions.*;

/**
 * @author Felipe Turetti Peruci
 * @author Marcos Vinicius Procykevicz
 * @version 1.2
 */
public class InventaFuncionamentoModificador {
	private ArrayList<FuncionamentoModificador> fMs = new ArrayList<FuncionamentoModificador>();
	Random rng = new Random();
	private int funcionamentoAtual;
	
	public InventaFuncionamentoModificador() {
		fMs.add(new MaxNTentativas(4));
		fMs.add(new MaxNTentativas(8));
		fMs.add(new ErrouAcabou());
	}
	
	/**
	 * @return A palavra atual após embaralhar
	 */
	public String getPalavra() {
		return this.getFuncionamento().getPalavra();
	}

	/**
	 * @return O FuncionamentoModificador atual
	 */
	public FuncionamentoModificador getFuncionamento() {
		
		return fMs.get(funcionamentoAtual);
	}
	
	/**
	 * Seleciona um funcionamento aleatório
	 */
	public void selectFuncionamento() {
		funcionamentoAtual = rng.nextInt(fMs.size());
		this.getFuncionamento().setPalavra();
	}

	/**
	 * @param i O índice do funcionamento
	 * Seleciona o funcionamento no índice i
	 */
	public void selectFuncionamento(int i) {
		funcionamentoAtual = i;
		this.getFuncionamento().setPalavra();
	}
	
	/**
	 * @param tentativa A palavra digitada pelo usuário
	 * @throws palavraLengthException 
	 */
	public void tentar(String tentativa) throws palavraLengthException{
		try {
			fMs.get(funcionamentoAtual).tentar(tentativa);
		}catch(palavraLengthException e) {
			throw e;
		}
	}
	
	/**
	 * @return Um valor booleano que indica se o usuário pode fazer uma tentativa
	 */
	public boolean podeTentar() {
		return fMs.get(funcionamentoAtual).podeTentar();
	}
	
	@Override
	public String toString() {
		return this.getFuncionamento().toString();
	}
	
	/**
	 * @return Nome do modificador atual
	 */
	public String getModificador() {
		return ConsoleColors.CYAN_BOLD_BRIGHT + this.getFuncionamento().getModificador() + ConsoleColors.RESET;
	}
	
	/**
	 * @return Nome do funcionamento atual
	 */
	public String getNomeFuncionamento() {
		return ConsoleColors.CYAN_BOLD_BRIGHT + this.getFuncionamento().getFuncionamento() + ConsoleColors.RESET;
	}

	public String getDescricao(){
		return this.getFuncionamento().getDescricao();
	}

	public int getQuantidadeLimite(){
		return this.getFuncionamento().getLimite();
	}

	public int getQuantidadeTentativa(){
		return this.getFuncionamento().getTentativas();
	}

	public int getQuantidadePontos(){
		return this.getFuncionamento().getPontos();
	}
}