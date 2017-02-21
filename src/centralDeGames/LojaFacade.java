package centralDeGames;

public class LojaFacade {

	private LojaController controller;

	public void adicionaUsuario(Usuario u) {
		controller.adicionaUsuario(u);
	}

	public void creditaUsuario(String login, double valor) {
		controller.creditaUsuario(login, valor);
	}

	public Usuario criaUsuario(String nome, String login, String nivel) {
		return controller.criaUsuario(nome, login, nivel);
	}

	public Jogo criaJogo(String nome, double preco, TiposDeJogo tipo, String modos) {
		return controller.criaJogo(nome, preco, tipo, modos);
	}

	public void venderJogo(String login, String nome, double preco, TiposDeJogo tipo, String modos) throws Exception {
		controller.venderJogo(login, nome, preco, tipo, modos);
	}

	public Usuario buscaUsuario(String login) {
		return controller.buscaUsuario(login);
	}

	public void upgradeUsuario(Usuario user) throws Exception {
		controller.upgradeUsuario(user);
	}

	public String toString() {
		return controller.toString();
	}
	
}
