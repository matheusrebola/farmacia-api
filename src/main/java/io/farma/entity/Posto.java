package io.farma.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	
	@ManyToOne
	@Column(name="tb_paciente_cd_paciente")
	private Paciente paciente;
	
	@OneToOne
	@Column(name="tb_paciente_fk_endereco")
	private Endereco endereco;
	
	@OneToMany
	@Column(name="tb_paciente_fk_paciente")
	private Medicamento medicamento;
	
	@OneToMany
	@Column(name="tb_posto_fk_data")
	private Data data;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
