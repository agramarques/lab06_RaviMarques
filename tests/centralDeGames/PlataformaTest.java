package centralDeGames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlataformaTest {

	Plataforma jogo;
	
	@Before
	public void criaJogo() throws Exception{
		jogo = new Plataforma("teste");
	}
	
	@Test
	public void testCalculaX2p() {
		int valor =	jogo.registraJogada(1000, true);
		assertEquals(20, valor);
		valor =	jogo.registraJogada(1000, false);
		assertEquals(0, valor);
	}

}
