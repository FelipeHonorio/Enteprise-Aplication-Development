package br.com.fiap.teste;

import br.com.fiap.anotacao.Tabela;
import br.com.fiap.bean.Pessoa;

public class TesteQuery {
	
	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		Tabela anot = p.getClass().getAnnotation(Tabela.class);
		//Exibir o SQL
		System.out.println("SELECT * FROM " + anot.nome());
	}

}
