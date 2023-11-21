package io.farma.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	
	@Column(name="dt_data_atual")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataAtual;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private LocalDateTime dataNascimento;
	
	@Column(name="dt_idade")
	@Formula("dt_nascimento-dt_data_atual")
	private LocalDateTime idade;
	
	@Column(name="dt_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime cadastro;
	
	@Column(name="dt_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime atualizacao;
	
	@Column(name="dt_vencimento")
	@Temporal(TemporalType.DATE)
	private LocalDateTime vencimento;
	
	@Column(name="dt_retirada")
	@Temporal(TemporalType.DATE)
	private LocalDateTime retirada;
	
	@Column(name="dt_chegada")
	@Temporal(TemporalType.DATE)
	private LocalDateTime chegada;
	
	@ManyToOne
	@JoinColumn(name="tb_posto_cd_posto")
	private Posto dataPosto;
	
	@ManyToOne
	@JoinColumn(name="tb_paciente_cd_paciente")
	private Paciente dataPaciente;
	
	@ManyToOne
	@JoinColumn(name="tb_endereco_cd_endereco")
	private Endereco dataEndereco;
	
	@ManyToOne
	@JoinColumn(name="tb_dosagem_cd_dosagem")
	private Dosagem dataDosagem;
	
	@ManyToOne
	@JoinColumn(name="tb_duracao_cd_duracao")
	private Duracao dataDuracao;
	
	@ManyToOne
	@JoinColumn(name="tb_medicamento_cd_medicamento")
	private Medicamento dataMedicamento;
	
	@ManyToOne
	@JoinColumn(name="tb_cartela_cd_cartela")
	private Cartela dataCartela;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
