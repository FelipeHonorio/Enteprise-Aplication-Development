package br.com.fiap.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.FarmaciaDAO;
import br.com.fiap.dao.impl.FarmaciaDAOImpl;
import br.com.fiap.entity.Farmacia;
import br.com.fiap.entity.Tipo;
import br.com.fiap.exception.CodigoInvalidoExpetion;
import br.com.fiap.exception.CommitException;

public class Teste {

	public static void main(String[] args) {

		//Instanciar a galera
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE"); 
		
		EntityManager em = fabrica.createEntityManager();
		
		FarmaciaDAO dao = new FarmaciaDAOImpl(em);
		
		//Cadastrar uma Farmácia
		dao.cadastrar(
				new Farmacia("Drogazil", 
				new GregorianCalendar(2010, Calendar.JANUARY,15), 
				Tipo.COMUM, true)
				);
		try {
			dao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Pesquisar
		Farmacia far = dao.buscar(1);
		System.out.println(far.getNomeFarmacia());
		
		//Atualizar
		far.setNomeFarmacia("SuperDroga");
		dao.atualizar(far);
		
		//Deletar
		try {
			dao.deletar(far.getCodigoFarmacia());
			dao.commit();
		} catch (CodigoInvalidoExpetion e) {
			e.printStackTrace();
		} catch (CommitException e) {
			e.printStackTrace();
		} 
		
		
		
		
		em.close();
		fabrica.close();
	}

}
