package io.farma.entity;

import java.time.LocalDateTime;
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
	private Dosagem dosagem;
	
	@OneToMany(mappedBy="cartelaDuracao")
	private Collection<Cartela> cartela;
	
	@OneToMany(mappedBy="dataDuracao")
	private Collection<Data> data;
	
	@Column(name="vl_ativo")
	private boolean ativo;
}
