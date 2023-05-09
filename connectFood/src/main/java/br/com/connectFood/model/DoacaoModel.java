package br.com.connectFood.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_DOACAO")
public class DoacaoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "descricao")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "id_rest")
	private RestauranteModel restaurante;

	@ManyToOne
	@JoinColumn(name = "id_inst")
	private InstituicaoModel instituicao;

	@JoinColumn(name = "dt_agendamento")
	@Temporal(TemporalType.DATE)
	private Date dataAgendamento;

	public DoacaoModel() {

	}

	public DoacaoModel(int id, RestauranteModel restaurante, InstituicaoModel instituicao) {
		super();
		this.id = id;
		this.restaurante = restaurante;
		this.instituicao = instituicao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	@Override
	public String toString() {
		return "DoacaoModel [id=" + id + ", restaurante=" + restaurante + ", instituicao=" + instituicao + "descricao"
				+ descricao +"]";
	}

}