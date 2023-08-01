package funcionamentoModificadores;

/**
 * @author Felipe Turetti Peruci
 * @version 1.0
 */
public interface FuncionamentoModificador {
	public void tentar(String tentativa);
	public void setPalavra();
	public String getPalavra();
	public boolean podeTentar();
	@Override
	public String toString();
}
