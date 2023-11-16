package io.farma.entity;

import java.util.Collection;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="tb_dosagem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dosagem {
	@Id
	@GeneratedValue
	@Column(name="cd_dosagem")
	private UUID id;
	
	@Column(name="en_valor_dosagem")
	@Enumerated(EnumType.STRING)
	private ValorDosagem valorDosagem;
	
	@ManyToOne
	@JoinColumn(name="tb_paciente_cd_paciente")
	private Paciente dosagemPaciente;
	
	@ManyToOne
	@JoinColumn(name="tb_medicamento_cd_medicamento")
	private Medicamento dosagemMedicamento;
	
	@OneToOne
	private Duracao duracao;
	
	@OneToMany(mappedBy="dataDosagem")
	private Collection<Data> data;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
