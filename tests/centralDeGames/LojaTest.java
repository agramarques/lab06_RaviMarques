package centralDeGames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LojaTest { //obs.: testando apenas o metodo upgradeUsuario, as demais delegam para Usuario

	private LojaController lojaController;
	Usuario u1;
	
	@Before
	public void criaLoja() throws Exception {
		lojaController = new LojaController();
		u1 = new Usuario("joao", "joao");
		u1.setStatus(new Noob());
	}
	
	@Test
	public void testUpgradeUsuario() throws Exception {
		u1.setX2p(1000);
		lojaController.adicionaUsuario(u1);
		lojaController.upgradeUsuario(u1.getLogin());
		assertEquals("Veterano", u1.getStatus());
	}

	@Test
	public void testUpgradeUsuarioExc() throws Exception {
		
		//tenta fazer upgrade de um usuario nao cadastrado
		try {
			lojaController.upgradeUsuario(u1.getLogin());
			fail();
		}
		catch (Exception e){
			assertEquals("usuario nao cadastrado", e.getMessage());
		}
		
		u1.setX2p(500);
		lojaController.adicionaUsuario(u1);
		
		//usuario cadastrado, mas com pontuacao insuficiente
		try {
			lojaController.upgradeUsuario(u1.getLogin());
			fail();
		}
		catch (Exception e){
			assertEquals("usuario nao tem pontos suficientes para upgrade", e.getMessage());
		}
		
	}
	
}
