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
@Table(name="tb_medicamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medicamento {
	@Id
	@GeneratedValue
	@Column(name="cd_medicamento")
	private UUID id;
	
	@Column(name="nm_nome")
	private String nome;
	
	@Column(name="tx_descricao")
	private String descricao;
	
	@Column(name="tx_indicacao")
	private String indicacao;
	
	@ManyToOne
	@JoinColumn(name="tb_paciente_cd_paciente")
	private Paciente medicamentoPaciente;
	
	@ManyToOne
	@JoinColumn(name="tb_posto_cd_posto")
	private Posto medicamentoPosto;
	
	@OneToMany(mappedBy="dataMedicamento")
	private Collection<Data> data;
	
	@OneToMany(mappedBy="cartelaMedicamento")
	private Collection<Cartela> cartela;
	
	@OneToMany(mappedBy="dosagemMedicamento")
	private Collection<Dosagem> dosagem;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
