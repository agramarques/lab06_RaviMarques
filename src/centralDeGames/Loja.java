package centralDeGames;

import java.util.HashMap;

public class Loja {

		private HashMap<String, Usuario> usuarios;

		public Loja() {
			usuarios = new HashMap<>();
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

		/**
		 * Recebe os atributos de um jogo a ser comprado e cria o objeto, a fim de evitar multiplos acessos ao mesmo objeto
		 * ja que se fosse passado o objeto, seria por referencia, assim mais de um usuario poderiam comprar o mesmo jogo (mesma instancia)
		 * @param login
		 * @param nome
		 * @param preco
		 * @param tipo usado para definir em tempo de execucao o tipo de jogo a ser criado
		 * @throws Exception
		 */
		public void venderJogo(String login, String nome, double preco, TiposDeJogo tipo) throws Exception{
			Jogo novo;
			if(tipo == TiposDeJogo.RPG){
				novo = new RPG(nome);
			}
			else if (tipo == TiposDeJogo.RPG){
				novo = new Luta(nome);
			}
			else{
				novo = new Plataforma(nome);
			}
			novo.setPreco(preco);
			try {
				usuarios.get(login).comprarJogo(novo);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public Usuario buscaUsuario(String login){
			return usuarios.get(login);
		}
		
		public void upgradeUsuario(Usuario user) throws Exception{
			if(!usuarios.containsKey(user.getLogin())){
				throw new Exception("usuario nao cadastrado");
			}
			if(user.getClass().equals(Veterano.class)){
				throw new Exception("usuario ja eh veterano");
			}
			if(user.getX2p() < 1000){
				throw new Exception("usuario nao tem pontos suficientes para upgrade");
			}
			Veterano novo = new Veterano(user.getNome());
			novo.copiarUsuario(user);	//copia as informacoes do usuario
			usuarios.remove(user.getLogin());	//remove usuario antigo (noob)
			usuarios.put(novo.getLogin(), novo); //inclui novo usuario (veterano)
		}

		@Override
		public String toString() {
			return "Loja [usuarios=" + usuarios + "]";
		}
}
