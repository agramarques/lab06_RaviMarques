package centralDeGames;

public class Luta extends Jogo {

	public Luta(String nome) throws Exception {
		super(nome);
		this.setTipo(TiposDeJogo.Luta);
	}

	@Override
	public int calculaX2p(int score, boolean zerou) {
		if (score>this.getMaiorScore()){
			return score/1000;
		}
		else{
			return 0;
		}
	}

}
