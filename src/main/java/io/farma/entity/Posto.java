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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_posto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Posto {
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name="nm_nome")
	private String nome;
	
	@JoinColumn(name="tb_paciente_cd_paciente")
	@ManyToOne
	private Paciente pacientePosto;
	
	@OneToOne
	private Endereco endereco;
	
	@OneToMany(mappedBy="medicamentoPosto")
	private Collection<Medicamento> medicamento;
	
	@OneToMany(mappedBy="dataPosto")
	private Collection<Data> data;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
