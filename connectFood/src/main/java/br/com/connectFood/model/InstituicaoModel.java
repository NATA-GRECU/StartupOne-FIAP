package br.com.connectFood.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "estado_inst", length = 40, nullable = false)
	private String estado;

	@Column(name = "cidade_inst", length = 40, nullable = false)
	private String cidade;

	@Column(name = "bairro_inst", length = 60, nullable = false)
	private String bairro;

	@Column(name = "rua_inst", length = 100, nullable = false)
	private String rua;

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
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "InstituicaoModel [id=" + id + ", nomeInstituicao=" + nomeInstituicao + "estado=" + estado + "cidade=" + cidade +", bairro=" + bairro + ", rua="
				+ rua + ", cnpj=" + cnpj + ", telefone=" + telefone + "]";
	}

}
