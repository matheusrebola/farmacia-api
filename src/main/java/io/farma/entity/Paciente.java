package io.farma.entity;

import java.util.Collection;
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
	private Endereco endereco;
	
	@OneToMany(mappedBy="pacientePosto")
	private Collection<Posto> posto;
	
	@OneToMany(mappedBy="medicamentoPaciente")
	private Collection<Medicamento> medicamento;
	
	@OneToMany(mappedBy="dosagemPaciente")
	private Collection<Dosagem> dosagem;
	
	@OneToMany(mappedBy="dataPaciente")
	private Collection<Data> data;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
