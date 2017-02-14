package centralDeGames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LutaTest {

	private Luta jogo;
	
	@Before
	public void criaJogo() throws Exception{
		jogo = new Luta("teste");
	}
	
	@Test
	public void testJogo() {
		assertEquals("teste", jogo.getNome());
		assertEquals(TiposDeJogo.Luta, jogo.getTipo());
	}

	@Test
	public void testJogoExc() {
		try{
			new Luta(null);
		}
		catch (Exception e){
			assertEquals("nome invalido", e.getMessage());
		}
		
		try{
			new Luta("");
		}
		catch (Exception e){
			assertEquals("nome invalido", e.getMessage());
		}
	}
	
	
	@Test
	public void testRegistraJogada() {
		//jogo eh de luta
		int valor =	jogo.registraJogada(1000, false);
		assertEquals(1000, jogo.getMaiorScore());
		assertEquals(1, jogo.getQuantPartidas());
		assertEquals(0, jogo.getQuantZeradas());
		assertEquals(1, valor);	//testa o retorno do x2p
	}

}
