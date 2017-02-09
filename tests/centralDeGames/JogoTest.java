package centralDeGames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoTest {

	private Jogo jogo;
	
	@Before
	public void criaJogo() throws Exception{
		jogo = new Jogo("teste", TiposDeJogo.Luta);
	}
	
	@Test
	public void testJogo() {
		assertEquals("teste", jogo.getNome());
		assertEquals(TiposDeJogo.Luta, jogo.getTipo());
	}

	@Test
	public void testJogoExc() {
		try{
			new Jogo(null, TiposDeJogo.Luta);
		}
		catch (Exception e){
			assertEquals("nome invalido", e.getMessage());
		}
		
		try{
			new Jogo("", TiposDeJogo.Luta);
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
		jogo.setTipo(TiposDeJogo.Plataforma); //muda o tipo de jogo para testar os outros casos
		valor = jogo.registraJogada(1000, true);
		assertEquals(2, jogo.getQuantPartidas());
		assertEquals(1, jogo.getQuantZeradas());
		assertEquals(20, valor);	//testa o retorno do x2p
		jogo.setTipo(TiposDeJogo.RPG);
		valor = jogo.registraJogada(1000, true);
		assertEquals(10, valor);
		
	}

}
