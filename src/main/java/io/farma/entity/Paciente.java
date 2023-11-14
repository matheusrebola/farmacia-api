package io.farma.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_paciente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paciente {
	@Id
	@GeneratedValue
	@Column(name="cd_paciente")
	private UUID id;
	
	@Column(name="nm_nome")
	private String nome;
	
	@Column(name="nm_sobrenome")
	private String sobrenome;
	
	@OneToOne
	@Column(name="tb_paciente_fk_endereco")
	private Endereco endereco;
	
	@OneToMany
	@Column(name="tb_paciente_fk_posto")
	private Posto posto;
	
	@OneToMany
	@Column(name="tb_paciente_fk_medicamento")
	private Medicamento medicamento;
	
	@OneToMany
	@Column(name="tb_paciente_fk_dosagem")
	private Dosagem dosagem;
	
	@OneToMany
	@Column(name="tb_paciente_fk_data")
	private Data data;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
