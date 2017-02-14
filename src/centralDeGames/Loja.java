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

		public void venderJogo(String login, Jogo jogo){
			try {
				usuarios.get(login).comprarJogo(jogo);
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
