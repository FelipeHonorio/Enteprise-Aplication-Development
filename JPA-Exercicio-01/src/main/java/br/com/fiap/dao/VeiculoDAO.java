package br.com.fiap.dao;

import br.com.fiap.entity.Veiculo;

public interface VeiculoDAO {
	
	void cadastrar(Veiculo veiculo);
	
	void deletar(int id);
	
	void atualizar(int id);
	
	Veiculo buscar(int id);
	
}
