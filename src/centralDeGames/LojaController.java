package centralDeGames;

import java.util.HashMap;

public class LojaController {

		private HashMap<String, Usuario> usuarios;
		private FactoryDeUsuario factory;
		private FactoryDeJogos gameFactory;

		public LojaController() {
			usuarios = new HashMap<>();
			factory = new FactoryDeUsuario();
			gameFactory = new FactoryDeJogos();
		}
		
		public void adicionaUsuario (Usuario u){
			usuarios.put(u.getLogin(), u);
		}
		
		public void creditaUsuario(String login, double valor){
			try {
				usuarios.get(login).colocarCredito(valor);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public Usuario criaUsuario (String nome, String login, String nivel){
			Usuario retorno = null;
			try {
				retorno = factory.getUsuario(nivel, nome, login);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return retorno;
		}
		
		public Jogo criaJogo(String nome, double preco, TiposDeJogo tipo, String modos){
			Jogo retorno = null;
			try {
				retorno = gameFactory.criaJogo(nome, preco, tipo, modos);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return retorno;
		}

		/**
		 * Recebe os atributos de um jogo a ser comprado e cria o objeto, a fim de evitar multiplos acessos ao mesmo objeto
		 * ja que se fosse passado o objeto, seria por referencia, assim mais de um usuario poderiam comprar o mesmo jogo (mesma instancia)
		 * @param login
		 * @param nome
		 * @param preco
		 * @param tipo usado para definir em tempo de execucao o tipo de jogo a ser criado
		 * @throws Exception
		 */
		public void venderJogo(String login, String nome, double preco, TiposDeJogo tipo, String modos) throws Exception{
			Jogo novo = this.criaJogo(nome, preco, tipo, modos);
			try {
				usuarios.get(login).comprarJogo(novo);	//chamada polimorfica
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public Usuario buscaUsuario(String login){
			return usuarios.get(login);
		}
		
		public void upgradeUsuario(String login) throws Exception{
			if(!usuarios.containsKey(login)){
				throw new Exception("usuario nao cadastrado");
			}
			Usuario user = usuarios.get(login);
			if(user.getClass().equals(Veterano.class)){
				throw new Exception("usuario ja eh veterano");
			}
			if(user.getX2p() < 1000){
				throw new Exception("usuario nao tem pontos suficientes para upgrade");
			}
			user.upgrade();	//chamada polimorfica
/*			Veterano novo = new Veterano(user.getNome(), user.getLogin());
			novo.copiarUsuario(user);	//copia as informacoes do usuario
			usuarios.remove(user.getLogin());	//remove usuario antigo (noob)
			usuarios.put(novo.getLogin(), novo); //inclui novo usuario (veterano)	*/
		}

		@Override
		public String toString() {
			return "Loja [usuarios=" + usuarios + "]";
		}
}
