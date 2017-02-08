package centralDeGames;

import java.util.HashMap;

public abstract class Usuario {

	private String nome;
	private String login;
	private HashMap<String, Jogo> comprados;
	private double creditos;
	private double x2p;

	public Usuario(String nome) {
		this.nome = nome;
		comprados = new HashMap<>();
		creditos = 0;
	}
	
	public abstract void comprarJogo(Jogo novo) throws Exception;
	
	public void colocarCredito(double valor) throws Exception{
		if (valor < 0){
			throw new Exception("valor invalido");
		}
		else{
			creditos += valor;	
		}
	}
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws Exception{
		if(!comprados.containsKey(nomeDoJogo)){
			throw new Exception("usuario nao possui jogo informado");
		}
		else{
			double acrescimoX2p = comprados.get(nomeDoJogo).registraJogada(score, zerou);
			this.setX2p(this.getX2p()+acrescimoX2p);
		}
	}

	public double calculaPrecoTotalJogos(){	//retorna valor total que o usuario possui em jogos comprados
		double total = 0;
		for(Jogo j:comprados.values()){
			total += j.getPreco();
		}
		return total;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public HashMap<String, Jogo> getComprados() {
		return comprados;
	}

	public double getCreditos() {
		return creditos;
	}

	protected void setCreditos(double creditos) {
		this.creditos = creditos;
	}

	public double getX2p() {
		return x2p;
	}

	protected void setX2p(double x2p) {
		this.x2p = x2p;
	}

	@Override
	public abstract String toString();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	
	
	
}
