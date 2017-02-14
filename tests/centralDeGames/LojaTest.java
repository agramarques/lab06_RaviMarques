package centralDeGames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LojaTest { //obs.: testando apenas o metodo upgradeUsuario, as demais delegam para Usuario

	private Loja loja;
	Noob u1;
	
	@Before
	public void criaLoja() throws Exception {
		loja = new Loja();
		u1 = new Noob("joao");
	}
	
	@Test
	public void testUpgradeUsuario() throws Exception {
		u1.setX2p(1000);
		loja.adicionaUsuario(u1);
		loja.upgradeUsuario(u1);
		Usuario upgraded = loja.buscaUsuario(u1.getLogin());
		assertTrue(upgraded.getClass().equals(Veterano.class)); //checa que a classe do usuario cadastrado com aquele login mudou para Veterano
	}

	@Test
	public void testUpgradeUsuarioExc() throws Exception {
		
		//tenta fazer upgrade de um usuario nao cadastrado
		try {
			loja.upgradeUsuario(u1);
			fail();
		}
		catch (Exception e){
			assertEquals("usuario nao cadastrado", e.getMessage());
		}
		
		u1.setX2p(500);
		loja.adicionaUsuario(u1);
		
		//usuario cadastrado, mas com pontuacao insuficiente
		try {
			loja.upgradeUsuario(u1);
			fail();
		}
		catch (Exception e){
			assertEquals("usuario nao tem pontos suficientes para upgrade", e.getMessage());
		}
		
		Veterano u2 = new Veterano("maria");
		//tenta fazer upgrade de um Veterano
		try {
			loja.upgradeUsuario(u2);
			fail();
		}
		catch (Exception e){
			assertEquals("usuario ja eh veterano", e.getMessage());
		}
		
	}
	
}
