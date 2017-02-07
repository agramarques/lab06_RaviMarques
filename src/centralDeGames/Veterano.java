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
			double novoX2p = this.getX2p() + (15*novo.getPreco());
			this.setX2p(novoX2p);
		}	
	}

	@Override
	public String toString() {
		return this.getLogin() + '\n' + this.getNome() + " - Jogador Veterano\n" + "Lista de Jogos:\n" + this.getComprados() + "\n\n" + "Total de preco dos jogos: R$" + this.calculaPrecoTotalJogos();  
	}


}
