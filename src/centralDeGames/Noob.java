package centralDeGames;

public class Noob extends Usuario{

	public Noob(String nome, String login) throws Exception{
		super(nome, login);
		this.setX2p(0);
	}

	@Override
	public void comprarJogo(Jogo novo) throws Exception {
		double precoComDesconto = novo.getPreco()*0.9;
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

	@Override
	public String toString() {
		return this.getLogin() + '\n' + this.getNome() + " - Jogador Noob\n" + "Lista de Jogos:\n" + this.getComprados() + "\n\n" + "Total de preco dos jogos: R$" + this.calculaPrecoTotalJogos();  
	}
	
}
