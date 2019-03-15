package br.com.fiap.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import br.com.fiap.dao.MercadoDAO;
import br.com.fiap.dao.impl.MercadoDAOImpl;
import br.com.fiap.entity.CategoriaMercado;
import br.com.fiap.entity.Mercado;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;

class MercadoDAOTest {

	private static MercadoDAO dao;

	@BeforeAll // executa antes de todos os testes
	public static void init() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		dao = new MercadoDAOImpl(em);
	}

	private Mercado mercado;
	
	@BeforeEach // executa antes de cada teste
	public void antesDeCadastrar() {
		mercado = new Mercado("Andorinha", "Santana", CategoriaMercado.HIPER,
				new GregorianCalendar(1999, Calendar.AUGUST, 1));
		// Act - chamar o método que será testado
		try {
			dao.cadastrar(mercado);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no commit");
		}
	}

	@Test
	@DisplayName("Teste de busca do DAO genérico")
	void buscaTest() {
		// Arrange - Instanciar as classes
		Mercado mercado = new Mercado("Andorinha", "Santana", CategoriaMercado.HIPER,
				new GregorianCalendar(1999, Calendar.AUGUST, 1));
		// Act - chamar o método
		try {
			dao.cadastrar(mercado);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no commit");
		}
		try {
			Mercado busca = dao.buscar(mercado.getCodigo());
			// Arrange - validação do resultado
			assertNotNull(busca);
			assertEquals("Andorinha", busca.getNome());

		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
			fail("Falha na pesquisa");
		}
	}

	@Test
	void cadastrarTest() {
		assertNotEquals(0, mercado.getCodigo());
	}
	
	@Test
	@DisplayName("Teste de alteração com sucesso")
	void alterar() {
		Mercado alterado = new Mercado(mercado.getCodigo(),
				"Javinha", "Av.paulista", CategoriaMercado.SUPER,
				Calendar.getInstance());
		try {
			// alterar
			dao.alterar(alterado);
			dao.commit();
			// Buscar e validar se alterou
			Mercado busca = dao.buscar(mercado.getCodigo());
			assertEquals(alterado.getNome(), busca.getNome());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha na pesquisa");
		}
	}
	
	@Test()
	@DisplayName("Teste de remocoção com sucesso")
	void remover() {
		try {
			dao.remover(mercado.getCodigo());
			dao.commit();
		} catch (CodigoInvalidoException | CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertThrows(CodigoInvalidoException.class, 
				()-> dao.buscar(mercado.getCodigo()));
	}

	
	

}
