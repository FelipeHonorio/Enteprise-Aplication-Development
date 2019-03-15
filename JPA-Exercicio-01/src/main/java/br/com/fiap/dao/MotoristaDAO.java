package br.com.fiap.dao;

import br.com.fiap.entity.Motorista;

public interface MotoristaDAO {

	void cadastrar(Motorista veiculo);
	
	void deletar(int id);
	
	void atualizar(int id);
	
	Motorista buscar(int id);
	
}
