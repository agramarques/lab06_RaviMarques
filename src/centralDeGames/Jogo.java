package centralDeGames;

import java.util.HashSet;

public class Jogo {
	
	private String nome;
	private double preco;
	private int maiorScore;
	private int quantPartidas;
	private int quantZeradas;
	private HashSet<Jogabilidade> modos;
	private TiposDeJogo tipo;
	
	public Jogo(String nome, TiposDeJogo tipo) throws Exception {
		if(nome == null || nome.trim().equals("")){
			throw new Exception("nome invalido");
		}
		this.nome = nome;
		this.setTipo(tipo);
		modos = new HashSet<>();
		maiorScore = 0;
		quantPartidas = 0;
		quantZeradas = 0;
	}	

	/**
	 * usada para obter os pontos x2p de cada jogada
	 * @param score
	 * @param zerou
	 * @return pontos x2p
	 */
	public int registraJogada(int score, boolean zerou){
		boolean foiMaior = false;
		if (score > maiorScore){
			maiorScore = score;
			foiMaior = true;
		}
		quantPartidas++;
		if(zerou){
			quantZeradas++;
		}
		switch (this.getTipo()) {
		case RPG:
			return 10;
		case Luta:
			if (foiMaior){
				return score/1000;
			}
			else{
				return 0;
			}
		case Plataforma:
			if(zerou){
				return 20;
			}
			else{
				return 0;
			}
		default:
			return 0;
		}
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

	public TiposDeJogo getTipo() {
		return tipo;
	}

	public void setTipo(TiposDeJogo tipo) {
		this.tipo = tipo;
	}

	public HashSet<Jogabilidade> getModos() {
		return modos;
	}

	@Override
	public String toString() {
		return "+" + this.getNome() + '-' + this.getTipo() + ":\n" + "==> Jogou " + this.getQuantPartidas() + "vez(es)\n" + "==> Zerou " + this.getQuantZeradas() + "vez(es)\n" + "==> Maior score: " + this.getMaiorScore(); 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
