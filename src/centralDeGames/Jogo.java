package centralDeGames;

import java.util.HashSet;

public class Jogo {
	
	private String nome;
	private double preco;
	private int maiorScore;
	private int quantPartidas;
	private int quantZeradas;
	private HashSet<Jogabilidade> modos;
	
	public Jogo(String nome) {
		this.nome = nome;
		modos = new HashSet<>();
		maiorScore = 0;
		quantPartidas = 0;
		quantZeradas = 0;
	}	

	public int registraJogada(int score, boolean zerou){
		if (score > maiorScore){
			maiorScore = score;
		}
		return score; //esperando forma de calcular x2p
	}
	
	public void adicionaModo(Jogabilidade modo){
		modos.add(modo);
	}
	
	public void removeModo(Jogabilidade modo){
		modos.remove(modo);
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantPartidas() {
		return quantPartidas;
	}

	public void setQuantPartidas(int quantPartidas) {
		this.quantPartidas = quantPartidas;
	}

	public int getQuantZeradas() {
		return quantZeradas;
	}

	public void setQuantZeradas(int quantZeradas) {
		this.quantZeradas = quantZeradas;
	}

	public String getNome() {
		return nome;
	}

	public int getMaiorScore() {
		return maiorScore;
	}
	
	
}
