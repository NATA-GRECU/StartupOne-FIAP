package br.com.connectFood.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_DOACAO")
public class DoacaoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nm_doador", length = 60, nullable = false)
	private String nomeDoador;

	@Column(name = "nm_donatario", length = 60, nullable = false)
	private String nomeDonatario;

	@ManyToOne
	@JoinColumn(name = "id_rest")
	private RestauranteModel restaurante;

	@ManyToOne
	@JoinColumn(name = "id_inst")
	private InstituicaoModel instituicao;

	public DoacaoModel() {

	}

	public DoacaoModel(Long id, String nomeDoador, String nomeDonatario, RestauranteModel restaurante,
			InstituicaoModel instituicao) {
		super();
		this.id = id;
		this.nomeDoador = nomeDoador;
		this.nomeDonatario = nomeDonatario;
		this.restaurante = restaurante;
		this.instituicao = instituicao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoador() {
		return nomeDoador;
	}

	public void setNomeDoador(String nomeDoador) {
		this.nomeDoador = nomeDoador;
	}

	public String getNomeDonatario() {
		return nomeDonatario;
	}

	public void setNomeDonatario(String nomeDonatario) {
		this.nomeDonatario = nomeDonatario;
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
		return "DoacaoModel [id=" + id + ", nomeDoador=" + nomeDoador + ", nomeDonatario=" + nomeDonatario
				+ ", restaurante=" + restaurante + ", instituicao=" + instituicao + "]";
	}

}