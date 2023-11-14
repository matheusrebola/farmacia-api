package io.farma.entity;

import java.time.LocalDateTime;
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
@Table(name="tb_duracao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Duracao {
	@Id
	@GeneratedValue
	@Column(name="cd_duracao")
	private UUID id;
	
	@Column(name="dt_duracao")
	private LocalDateTime duracao;
	
	@OneToOne
	@Column(name="tb_dosagem_cd_dosagem")
	private Dosagem dosagem;
	
	@OneToMany
	@Column(name="tb_duracao_fk_cartela")
	private Cartela cartela;
	
	@OneToMany
	@Column(name="tb_duracao_fk_data")
	private Data data;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
