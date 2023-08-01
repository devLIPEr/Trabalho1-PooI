package funcionamentoModificadores;

public interface FuncionamentoModificador {
	public void tentar(String tentativa);
	public void setPalavra();
	public String getPalavra();
	public boolean podeTentar();
	@Override
	public String toString();
}
