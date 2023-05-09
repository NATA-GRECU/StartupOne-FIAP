package br.com.connectFood.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "T_INSTITUICAO")
public class InstituicaoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inst")
	private int id;

	@Column(name = "nm_inst", length = 100, nullable = false)
	private String nomeInstituicao;

	@Column(name = "endereco_inst", nullable = false)
	@OneToMany
	private List<AddressModel> endereco;

	@Column(name = "cnpj_inst", length = 30)
	private String cnpj;

	@Column(name = "tel_rest", length = 20)
	private String telefone;

	public InstituicaoModel() {

	}

	public InstituicaoModel(int id, String nomeInstituicao, String estado, String cidade, String bairro, String rua,
							String cnpj, String telefone) {
		this.id = id;
		this.nomeInstituicao = nomeInstituicao;
		this.cnpj = cnpj;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeRestaurante) {
		this.nomeInstituicao = nomeRestaurante;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "InstituicaoModel [id=" + id + ", nomeInstituicao=" + nomeInstituicao + ", cnpj=" + cnpj + ", telefone=" + telefone + "]";
	}

}
