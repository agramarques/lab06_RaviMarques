package centralDeGames;

public class RPG extends Jogo {

	public RPG(String nome) throws Exception {
		super(nome);
		this.setTipo(TiposDeJogo.RPG);
	}

	@Override
	public int calculaX2p(int score, boolean zerou) {
		return 10;
	}

}
