package ufape.poo.mensageiro.negocio.fachada;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.transaction.Transactional;
import ufape.poo.mensageiro.negocio.basica.*;
import ufape.poo.mensageiro.negocio.cadastro.exception.*;
import ufape.poo.mensageiro.negocio.fachada.Fachada;

@SpringBootTest
@Transactional

public class FachadaTest {
	
	@Autowired
	private Fachada fachada;
	
	@BeforeEach
	public void init() throws UsuarioDuplicadoException{
		
		Usuario u = new Usuario("Farao", "farao@piramide.com", "666");
		Usuario u2 = new Usuario("Farofa", "farofa@piramide.com", "666");
		Grupo g = new Grupo ("Pirâmide", u);
		
		fachada.salvarUsuario(u);
		fachada.salvarUsuario(u2);
		fachada.salvarGrupo(g);
		
	}
	
	@Test
	void testeAdicionarUsuarioGrupo() throws UsuarioNaoExisteException, UsuarioDuplicadoException{
		
		Grupo g = fachada.localizarGrupoId(1).get();
		int size = g.getMembros().size();
		fachada.adicionarUsuarioGrupo(1, "farofa@piramide.com");
		g = fachada.localizarGrupoId(1).get();
		int size2 = g.getMembros().size();
		assertEquals(size + 1, size2);
		
	}

}