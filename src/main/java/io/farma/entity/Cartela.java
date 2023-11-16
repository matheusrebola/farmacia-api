package io.farma.entity;

import java.util.Collection;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_cartela")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cartela {
	@Id
	@GeneratedValue
	@Column(name="cd_cartela")
	private UUID id;
	
	@Column(name="vl_quantidade")
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name="tb_medicamento_cd_medicamento")
	private Medicamento cartelaMedicamento;
	
	@ManyToOne
	@JoinColumn(name="tb_duracao_cd_duracao")
	private Duracao duracaoCartela;
	
	@OneToMany(mappedBy="dataCartela")
	private Collection<Data> data;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
