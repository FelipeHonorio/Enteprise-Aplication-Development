package br.com.fiap.revisao.bean;

import java.util.Calendar;

public class ContaCorrente extends Conta {

	private TipoConta tipo;
	
	public ContaCorrente() {
		super();
	}

	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	@Override
	public void depositar(double valor) {
		saldo = saldo + valor;
	}

	@Override
	public void retirar(double valor) {
		if (saldo > valor && tipo.equals(TipoConta.COMUM)) {
			saldo = saldo - valor;
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

}
