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
@Table(name="tb_endereco")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco {
	@Id
	@GeneratedValue
	@Column(name="cd_endereco")
	private UUID id;
	
	@Column(name="nm_cidade")
	private String cidade;
	
	@Column(name="nm_estado")
	private String estado;
	
	@Column(name="nm_cep")
	private String cep;
	
	@Column(name="nm_logradouro")
	private String logradouro;
	
	@Column(name="nm_numero")
	private String numero;
	
	@Column(name="nm_complemento")
	private String complemento;
	
	@OneToOne
	@Column(name="tb_paciente_cd_paciente")
	private Paciente paciente;
	
	@OneToOne
	@Column(name="tb_posto_cd_posto")
	private Posto posto;
	
	@OneToMany
	@Column(name="tb_endereco_fk_data")
	private Data data;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
