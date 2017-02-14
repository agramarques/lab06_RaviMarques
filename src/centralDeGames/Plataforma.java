package centralDeGames;

public class Plataforma extends Jogo {

	public Plataforma(String nome) throws Exception {
		super(nome);
		this.setTipo(TiposDeJogo.Plataforma);
	}

	@Override
	public int calculaX2p(int score, boolean zerou) {
		if (zerou){
			return 20;
		}
		else{
			return 0;
		}
	}

}
