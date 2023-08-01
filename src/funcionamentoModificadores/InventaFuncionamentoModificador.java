package funcionamentoModificadores;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Felipe Turetti Peruci
 * @version 1.0
 */
public class InventaFuncionamentoModificador {
	private ArrayList<FuncionamentoModificador> fNs = new ArrayList<FuncionamentoModificador>();
	Random rng = new Random();
	private int funcionamentoAtual;
	
	public InventaFuncionamentoModificador() {
		fNs.add(new MaxNTentativas(4));
		fNs.add(new MaxNTentativas(8));
		fNs.add(new ErrouAcabou());
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
		
		return fNs.get(funcionamentoAtual);
	}
	
	/**
	 * Seleciona um funcionamento aleatório
	 */
	public void selectFuncionamento() {
		funcionamentoAtual = rng.nextInt(fNs.size());
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
	 */
	public void tentar(String tentativa) {
		fNs.get(funcionamentoAtual).tentar(tentativa);
	}
	
	/**
	 * @return Um valor booleano que indica se o usuário pode fazer uma tentativa
	 */
	public boolean podeTentar() {
		return fNs.get(funcionamentoAtual).podeTentar();
	}
	
	@Override
	public String toString() {
		return this.fNs.get(this.funcionamentoAtual).toString();
	}
}
