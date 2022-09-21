package br.com.startupone.connectFood.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_INSTITUICAO")
public class InstituicaoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inst")
	private Long id;

	@Column(name = "nm_inst", length = 100, nullable = false)
	private String nomeRestaurante;

	@Column(name = "bairro_inst", length = 60, nullable = false)
	private String bairro;

	@Column(name = "rua_inst", length = 100, nullable = false)
	private String rua;

	@Column(name = "cnpj_inst", length = 30)
	private String cnpj;

	@Column(name = "tel_rest", length = 20)
	private String telefone;

	@OneToMany(mappedBy = "instituicao")
	private List<DoacaoModel> doacao;

	public InstituicaoModel() {

	}

	public InstituicaoModel(Long id, String nomeRestaurante, String bairro, String rua, String cnpj, String telefone,
			List<DoacaoModel> doacao) {
		super();
		this.id = id;
		this.nomeRestaurante = nomeRestaurante;
		this.bairro = bairro;
		this.rua = rua;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.doacao = doacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeRestaurante() {
		return nomeRestaurante;
	}

	public void setNomeRestaurante(String nomeRestaurante) {
		this.nomeRestaurante = nomeRestaurante;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<DoacaoModel> getDoacao() {
		return doacao;
	}

	public void setDoacao(List<DoacaoModel> doacao) {
		this.doacao = doacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "InstituicaoModel [id=" + id + ", nomeRestaurante=" + nomeRestaurante + ", bairro=" + bairro + ", rua="
				+ rua + ", cnpj=" + cnpj + ", telefone=" + telefone + ", doacao=" + doacao + "]";
	}

}
