package io.farma.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Data {
	@Id
	@GeneratedValue
	@Column(name="cd_data")
	private UUID id;
	
	
	@Column(name="dt_nascimento")
	private LocalDateTime dataNascimento;
	
	@Column(name="dt_idade")
	private LocalDateTime idade;
	
	@Column(name="dt_cadastro")
	private LocalDateTime cadastro;
	
	@Column(name="dt_atualizacao")
	private LocalDateTime atualizacao;
	
	@Column(name="dt_vencimento")
	private LocalDateTime vencimento;
	
	@Column(name="dt_retirada")
	private LocalDateTime retirada;
	
	@Column(name="dt_chegada")
	private LocalDateTime chegada;
	
	@Column(name="tb_posto_cd_posto")
	private Posto posto;
	
	@ManyToOne
	@Column(name="tb_paciente_cd_paciente")
	private Paciente paciente;
	
	@ManyToOne
	@Column(name="tb_endereco_cd_endereco")
	private Endereco endereco;
	
	@ManyToOne
	@Column(name="tb_dosagem_cd_dosagem")
	private Dosagem dosagem;
	
	@ManyToOne
	@Column(name="tb_duracao_cd_duracao")
	private Duracao duracao;
	
	@ManyToOne
	@Column(name="tb_medicamento_cd_medicamento")
	private Medicamento medicamento;
	
	@ManyToOne
	@Column(name="tb_cartela_cd_cartela")
	private Cartela cartela;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
