package centralDeGames;

public class FactoryDeUsuario {

	public Usuario getUsuario(String nivel, String nome, String login) throws Exception{
		if (nivel.equalsIgnoreCase("veterano")){
			return new Veterano(nome, login);
		}
		else{
			return new Noob(nome, login);
		}
		
	}
	
	
}
