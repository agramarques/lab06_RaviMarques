package centralDeGames;

public class FactoryDeJogos {

	public Jogo criaJogo(String nome, double preco, TiposDeJogo tipo, String modos) throws Exception{
		Jogo novo;
		switch (tipo) {
		case RPG:
			novo = new RPG(nome);
		case Luta:
			novo = new Luta(nome);
		default:
			novo = new Plataforma(nome);			
		}
		novo.setPreco(preco);
		String[] listaEstilos = modos.split(" ");
		for(String a:listaEstilos){
			if (a.equalsIgnoreCase("competitivo")){
				novo.adicionaModo(Jogabilidade.Competitivo);
			}
			if (a.equalsIgnoreCase("cooperativo")){
				novo.adicionaModo(Jogabilidade.Cooperativo);
			}
			if (a.equalsIgnoreCase("multiplayer")){
				novo.adicionaModo(Jogabilidade.Multiplayer);
			}
			if (a.equalsIgnoreCase("offline")){
				novo.adicionaModo(Jogabilidade.Offline);
			}
			if (a.equalsIgnoreCase("online")){
				novo.adicionaModo(Jogabilidade.Online);
			}
		}
		return novo;
	}
	
}
