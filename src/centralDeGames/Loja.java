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

		@Override
		public String toString() {
			return "Loja [usuarios=" + usuarios + "]";
		}
}
