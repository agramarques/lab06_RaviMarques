package centralDeGames;

public class Veterano implements TipoDeUsuario{

	@Override
	public void punir(int am) {
		
	}

	@Override
	public void recompensar(int am) {
		
	}

	@Override
	public double getPrecoComDesconto(Jogo jogo) {
		return jogo.getPreco()*0.8;	//desconto do noob = 20%
	}

	@Override
	public int getAddX2p(Jogo jogo) {
		return (int)(15*jogo.getPreco());
	}
}
