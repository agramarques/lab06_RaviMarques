package centralDeGames;

import easyaccept.EasyAccept;

public class LojaFacade {

	private static LojaController controller = new LojaController();

	public static void main(String[] args){
		args = new String[] { "centralDeGames.LojaFacade", "acceptance_test/us1.txt", "acceptance_test/us2.txt",  "acceptance_test/us3.txt" };
		EasyAccept.main(args);
	}
	
	public void adicionaUsuario(Usuario u) {
		controller.adicionaUsuario(u);
	}

	public void adicionaCredito(String login, double valor) {
		controller.creditaUsuario(login, valor);
	}
	
	public double confereCredito(String login) {
		return controller.checaCredito(login);
	}

	public int getX2p(String login) {
		return controller.getX2p(login);
	}

	public Usuario criaUsuario(String nome, String login, String nivel) {
		return controller.criaUsuario(nome, login, nivel);
	}

	public Jogo criaJogo(String nome, double preco, TiposDeJogo tipo, String modos) {
		return controller.criaJogo(nome, preco, tipo, modos);
	}

	public void vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser) throws Exception {
		controller.venderJogo(loginUser, jogoNome, preco, estiloJogo, jogabilidades);
	}

	public void punir(String login, String nomeJogo, int scoreObtido, boolean zerou) throws Exception {
		controller.punir(login, nomeJogo, scoreObtido, zerou);
	}

	public void recompensar(String login, String nomeJogo, int scoreObtido, boolean zerou) throws Exception {
		controller.recompensar(login, nomeJogo, scoreObtido, zerou);
	}

	public Usuario buscaUsuario(String login) {
		return controller.buscaUsuario(login);
	}

	public void upgrade(String login) throws Exception {
		controller.upgradeUsuario(login);
	}

	public String toString() {
		return controller.toString();
	}
	
}
