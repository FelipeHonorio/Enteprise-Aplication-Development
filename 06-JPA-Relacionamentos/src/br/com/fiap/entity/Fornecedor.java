package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_FORNECEDOR")
@SequenceGenerator(name = "fornecedor", sequenceName = "SQ_FORNECEDOR", allocationSize = 1)
public class Fornecedor {

	@Id
	@Column(name = "cd_fornecedor")
	@GeneratedValue(generator = "fornecedor", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_fornecedor", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "nr_cnpj", length= 11, nullable = false)
	private String cnpj;
}
