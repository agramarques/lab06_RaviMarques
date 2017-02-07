package centralDeGames;

public class Veterano extends Usuario{

	public Veterano(String nome) {
		super(nome);
		this.setX2p(1000);
	}

	@Override
	public void comprarJogo(Jogo novo) throws Exception {
		double precoComDesconto = novo.getPreco()*0.8;
		if(precoComDesconto > this.getCreditos()){
			throw new Exception("voce nao tem credito para comprar esse jogo");
		}
		else{
			this.setCreditos(this.getCreditos() - precoComDesconto);
			this.getComprados().put(novo.getNome(), novo);
		}	
	}

	

}
