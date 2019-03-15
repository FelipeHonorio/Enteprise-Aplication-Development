package br.com.fiap.test;

import java.security.Permissions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Pastel;

public class RefreshTeste {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		// pesquisar o pastel de código 1
		Pastel pastel = em.find(Pastel.class, 1);
				
		//Exibir o sabor do pastel
		System.out.println(pastel.getSabor());
		
		//Modificar o sabor no java e exibir
		pastel.setSabor("Beterraba");
		System.out.println(pastel.getSabor());
		
		//faz o reflesh
		em.refresh(pastel);
		
		//exibit novamente o sabor
		System.out.println(pastel.getSabor());
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		//fechar as paradas
		em.close();
		fabrica.close();

	}

}
