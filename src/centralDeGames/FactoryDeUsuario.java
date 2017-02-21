package centralDeGames;

public class FactoryDeUsuario {

	public Usuario getUsuario(String nivel, String nome, String login) throws Exception{
		Usuario novo = new Usuario(nome, login);
		if (nivel.equalsIgnoreCase("veterano")){
			novo.upgrade();
		}
		return novo;
		
	}
	
	
}
