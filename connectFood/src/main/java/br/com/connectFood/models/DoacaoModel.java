package br.com.connectFood.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_DOACAO")
public class DoacaoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_rest")
	private RestauranteModel restaurante;

	@ManyToOne
	@JoinColumn(name = "id_inst")
	private InstituicaoModel instituicao;

	public DoacaoModel() {

	}

	public DoacaoModel(Long id, RestauranteModel restaurante, InstituicaoModel instituicao) {
		super();
		this.id = id;
		this.restaurante = restaurante;
		this.instituicao = instituicao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RestauranteModel getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteModel restaurante) {
		this.restaurante = restaurante;
	}

	public InstituicaoModel getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoModel instituicao) {
		this.instituicao = instituicao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DoacaoModel [id=" + id + ", restaurante=" + restaurante + ", instituicao=" + instituicao + "]";
	}

}