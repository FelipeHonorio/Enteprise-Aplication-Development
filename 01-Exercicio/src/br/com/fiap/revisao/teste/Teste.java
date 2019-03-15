package br.com.fiap.revisao.teste;

import java.util.Calendar;

import br.com.fiap.revisao.bean.ContaCorrente;
import br.com.fiap.revisao.bean.TipoConta;

public class Teste {

	public static void main(String[] args) {
	
		ContaCorrente cc = new ContaCorrente(01, 1234, Calendar.getInstance(), 1000, TipoConta.COMUM);
		
		//ContaPoupanca cp = new ContaPoupanca(02, 4321, Calendar.getInstance(), 3000,);

	}

}
