package br.com.fiap.revisao.bean;

import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento {

	private float taxa;
	private static final float RENDIMENTO = 0;
	
	@Override
	public float calculaRetornoInvestimento() {
		return (float) saldo * RENDIMENTO;
		
	}

	@Override
	public void depositar(double valor) {
		saldo = saldo + valor;
	}

	@Override
	public void retirar(double valor) {
		if (saldo >= valor + taxa) {
			saldo = saldo - (valor + taxa);
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public ContaPoupanca(int agencia, int numero, Calendar dataRetorno, double saldo) {
		super(agencia, numero, dataRetorno, saldo);

	}

	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}	

}
