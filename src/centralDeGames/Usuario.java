package centralDeGames;

import java.util.HashMap;

public abstract class Usuario {

	private String nome;
	private String login;
	private HashMap<String, Jogo> comprados;
	private double creditos;
	private int x2p;

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

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", login=" + login + ", creditos=" + creditos + "]";
	}

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
