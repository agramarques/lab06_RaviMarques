package centralDeGames;

public interface TipoDeUsuario {

//	public void comprarJogo(Jogo novo) throws Exception;
	public void punir(int am);
	public void recompensar(int am);
	public double getPrecoComDesconto(Jogo jogo);
	public int getAddX2p(Jogo jogo);
}
