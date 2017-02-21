package centralDeGames;

public class Noob implements TipoDeUsuario{

//	colocar isso no metodo de Usuario
/*	public void comprarJogo(Jogo novo) throws Exception {
		if(precoComDesconto > this.getCreditos()){
			throw new Exception("voce nao tem credito para comprar esse jogo");
		}
		else{
			this.setCreditos(this.getCreditos() - precoComDesconto);
			this.getComprados().put(novo.getNome(), novo);
			int novoX2p = this.getX2p() + (int)(10*novo.getPreco());
			this.setX2p(novoX2p);
		}	
	}
*/
	@Override
	public void punir(int am) {
		
	}

	@Override
	public void recompensar(int am) {
		
	}

	@Override
	public double getPrecoComDesconto(Jogo jogo) {
		return jogo.getPreco()*0.9;	//desconto do noob = 10%
	}

	@Override
	public int getAddX2p(Jogo jogo) {
		return (int)(10*jogo.getPreco());
	}
	
}
