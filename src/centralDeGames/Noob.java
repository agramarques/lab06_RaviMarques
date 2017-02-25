package centralDeGames;

public class Noob implements TipoDeUsuario{

	@Override
	public int punir(Jogo jogo, int scoreObtido, boolean zerou) {
		int deducao = 0;
		if(jogo.getModos().contains(Jogabilidade.Competitivo)){
			deducao -= 20;
		}
		if(jogo.getModos().contains(Jogabilidade.Online)){
			deducao -= 10;
		}
		if(jogo.getModos().contains(Jogabilidade.Cooperativo)){
			deducao -= 50;
		}
		return deducao;
	}

	@Override
	public int recompensar(Jogo jogo, int scoreObtido, boolean zerou) {
		int acrescimo = 0;
		if(jogo.getModos().contains(Jogabilidade.Offline)){
			acrescimo += 30;
		}
		if(jogo.getModos().contains(Jogabilidade.Multiplayer)){
			acrescimo += 10;
		}
		return acrescimo;
	}

	@Override
	public double getPrecoComDesconto(Jogo jogo) {
		return jogo.getPreco()*0.9;	//desconto do noob = 10%
	}

	@Override
	public int getAddX2p(Jogo jogo) {
		return (int)(10*jogo.getPreco());
	}

	@Override
	public String getStatus() {
		return "Noob";
	}
	
}
