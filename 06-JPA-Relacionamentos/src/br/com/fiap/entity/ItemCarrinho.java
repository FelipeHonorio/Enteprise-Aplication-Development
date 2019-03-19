package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "T_ITEM_CARRINHO")
@SequenceGenerator(name = "item_carrinho", sequenceName = "SQ_ITEM_CARRINHO", allocationSize = 1)
public class ItemCarrinho {
	
	@Id
	@GeneratedValue(generator = "item_carrinho", strategy = GenerationType.SEQUENCE)
	@Column(name="cd_item_carrinho")
	private int codigo;
	
	@ManyToAny(metaColumn = @Column)
	@JoinColumn(name = "cd_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "cd_produto")
	private CarrinhoCompras carrinho;
	
	@Column(name = "nr_quantidade")
	private int quantidade;
	
	@Column(name = "vl_item_carrinho")
	private double valor;
}
