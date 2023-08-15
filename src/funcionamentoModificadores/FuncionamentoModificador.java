package funcionamentoModificadores;
import exceptions.palavraLengthException;

/**
 * @author Felipe Turetti Peruci
 * @author Marcos Vinicius Procykevicz
 * @version 1.2
 */
public interface FuncionamentoModificador {
	public void tentar(String tentativa) throws palavraLengthException ;
	public void setPalavra();
	public String getPalavra();
	public String getModificador();
	public String getFuncionamento();
	public String getDescricao();
	public int getLimite();
	public int getTentativas();
	public int getPontos();
	public boolean podeTentar();
	@Override
	public String toString();
}