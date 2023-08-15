package funcionamentoModificadores;

import exceptions.palavraLengthException;

/**
 * @author Felipe Turetti Peruci
 * @version 1.1
 */
public interface FuncionamentoModificador {
	public void tentar(String tentativa) throws palavraLengthException ;
	public void setPalavra();
	public String getPalavra();
	public String getModificador();
	public String getFuncionamento();
	public boolean podeTentar();
	@Override
	public String toString();
}
