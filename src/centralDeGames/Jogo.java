package centralDeGames;

public class Jogo {
	
	public String nome;
	public double preco;
	public int maiorScore;
	public int quantPartidas;
	public int quantZeradas;
	
	public Jogo(String nome) {
		this.nome = nome;
		maiorScore = 0;
		quantPartidas = 0;
		quantZeradas = 0;
	}	

	
}
