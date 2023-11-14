package io.farma.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	@Column(name="tb_paciente_cd_paciente")
	private Paciente paciente;
	
	@ManyToOne
	@Column(name="tb_posto_cd_posto")
	private Posto posto;
	
	@OneToMany
	@Column(name="tb_medicamento_fk_data")
	private Data data;
	
	@OneToMany
	@Column(name="tb_medicamento_fk_cartela")
	private Cartela cartela;
	
	@OneToMany
	@Column(name="tb_medicamento_fk_dosagem")
	private Dosagem dosagem;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
