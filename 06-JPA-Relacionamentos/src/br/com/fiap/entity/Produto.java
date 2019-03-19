package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PRODUTO")
@SequenceGenerator(name = "produto", sequenceName = "SQ_PRODUTO", allocationSize = 1)
public class Produto {
	
	@Id
	@GeneratedValue(generator = "produto", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_produto")
	private int codigo;
	
	@OneToMany(mappedBy="produto")
	private List<ItemCarrinho> item;
	
	@Column(name = "nm_produto", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "vl_produto")
	private double valor;
}
