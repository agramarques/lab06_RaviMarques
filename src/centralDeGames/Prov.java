package centralDeGames;

public class Prov {

	public static void main(String[] args) throws Exception{
		Loja minha = new Loja();
		Usuario u = new Noob("Ravi");
		u.setLogin("ravi");
		Jogo j = new Jogo("first", TiposDeJogo.Luta);
		j.setPreco(200);
		minha.adicionaUsuario(u);
		minha.creditaUsuario(u.getLogin(), 1000);
		minha.venderJogo(u.getLogin(), j);
		System.out.println(minha);
	}

}
