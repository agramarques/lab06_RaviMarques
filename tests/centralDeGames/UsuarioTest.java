package centralDeGames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	private Usuario user;
	
	@Before
	public void criaNoob() throws Exception{
		user = new Usuario("joao", "joao");
	}

	@Test
	public void testComprarJogo() throws Exception {
		Jogo jogo = new Luta("first");
		jogo.setPreco(100);
		user.colocarCredito(200);
		user.comprarJogo(jogo);
		assertEquals(110, user.getCreditos(), 0.001); //abatido o preco do jogo com o desconto de 10% (noob)
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
	
	@Test
	public void testNoob() {
		assertEquals("joao", user.getNome());
	}

	@Test
	public void testColocarCredito() throws Exception {
		user.colocarCredito(1000);
		assertEquals(1000, user.getCreditos(), 0.1);
	}

	@Test
	public void testColocarCreditoExc(){
		try {
			user.colocarCredito(-1000);
		} catch (Exception e) {
			assertEquals("valor invalido", e.getMessage());
		}

	}
	
	@Test
	public void testCalculaPrecoTotalJogos() throws Exception {
		Jogo jogo = new Luta("first");
		jogo.setPreco(100);
		user.colocarCredito(400);
		user.comprarJogo(jogo);
		Jogo novo = new Luta("second");
		novo.setPreco(150);
		user.comprarJogo(novo);
		assertEquals(250, user.calculaPrecoTotalJogos(), 0.01);
	}

}
