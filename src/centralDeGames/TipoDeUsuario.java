package centralDeGames;

public interface TipoDeUsuario {

//	public void comprarJogo(Jogo novo) throws Exception;
	public int punir(Jogo jogo, int scoreObtido, boolean zerou);
	public int recompensar(Jogo jogo, int scoreObtido, boolean zerou);
	public double getPrecoComDesconto(Jogo jogo);
	public int getAddX2p(Jogo jogo);
}
