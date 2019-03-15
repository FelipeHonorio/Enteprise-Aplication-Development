package br.com.fiap.test;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Massa;
import br.com.fiap.entity.Pastel;

public class AtualizarPastel {
	
	public static void main(String[] args) {
		//Criar a fabrica de entity manager
		EntityManagerFactory fabrica  = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Criar Entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Criar um novo objeto com um id existente no banco
		
		Pastel pastel = new Pastel(1, "Especial com carne", 5, true, Massa.INTEGRALM,
				new GregorianCalendar(17,1,2019), null);
		em.merge(pastel);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar as paradas
		em.close();
		fabrica.close();
		
		
	}
}
