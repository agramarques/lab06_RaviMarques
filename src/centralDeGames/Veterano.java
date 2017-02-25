package centralDeGames;

public class Veterano implements TipoDeUsuario{

	@Override
	public int punir(Jogo jogo, int scoreObtido, boolean zerou) {
		int deducao = 0;
		if(jogo.getModos().contains(Jogabilidade.Competitivo)){
			deducao -= 20;
		}
		if(jogo.getModos().contains(Jogabilidade.Offline)){
			deducao -= 20;
		}
		return deducao;
	}

	@Override
	public int recompensar(Jogo jogo, int scoreObtido, boolean zerou) {
		int acrescimo = 0;
		if(jogo.getModos().contains(Jogabilidade.Online)){
			acrescimo += 10;
		}
		if(jogo.getModos().contains(Jogabilidade.Cooperativo)){
			acrescimo += 20;
		}
		return acrescimo;
	}

	@Override
	public double getPrecoComDesconto(Jogo jogo) {
		return jogo.getPreco()*0.8;	//desconto do noob = 20%
	}

	@Override
	public int getAddX2p(Jogo jogo) {
		return (int)(15*jogo.getPreco());
	}

	@Override
	public String getStatus() {
		return "Veterano";
	}
}
