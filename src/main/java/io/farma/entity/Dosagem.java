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
	private ValorDosagem valorDosagem;
	
	@OneToOne
	@Column(name="tb_paciente_cd_paciente")
	private Paciente paciente;
	
	@ManyToOne
	@Column(name="tb_medicamento_cd_medicamento")
	private Medicamento medicamento;
	
	@OneToOne
	@Column(name="tb_dosagem_fk_duracao")
	private Duracao duracao;
	
	@OneToMany
	@Column(name="tb_dosagem_fk_data")
	private Data data;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
