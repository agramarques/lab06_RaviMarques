package centralDeGames;

import java.util.HashMap;

public abstract class Usuario {

	private String nome;
	private String login;
	private HashMap<String, Jogo> comprados;
	private double creditos;

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
	
	
	
}
