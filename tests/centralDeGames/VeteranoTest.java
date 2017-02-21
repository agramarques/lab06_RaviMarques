package centralDeGames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VeteranoTest { //obs.: como veterano e noob herdam tudo de usuario, menos o comprarJogo, testei tudo em noob e so o ComprarJogo modificado em VeteranoTest

	private Veterano user;
	
	@Before
	public void criaNoob() throws Exception{
		user = new Veterano("joao", "joao");
	}

	@Test
	public void testComprarJogo() throws Exception {
		Jogo jogo = new Luta("first");
		jogo.setPreco(100);
		user.colocarCredito(200);
		user.comprarJogo(jogo);
		assertEquals(120, user.getCreditos(), 0.001); //abatido o preco do jogo com o desconto de 20% (veterano)
		assertTrue(user.getComprados().containsKey(jogo.getNome())); //checa se o jogo foi incluido na lista de comprados do usuario
	}

	@Test
	public void testComprarJogoExc() throws Exception {
		Jogo jogo = new Luta("first");
		jogo.setPreco(100);
		user.colocarCredito(50);
		try {
			user.comprarJogo(jogo);
		} catch (Exception e) {
			assertEquals("voce nao tem credito para comprar esse jogo", e.getMessage());
			assertFalse(user.getComprados().containsKey(jogo.getNome())); //checa se o jogo nao foi incluido na lista de comprados do usuario
		}
	}
	

}
