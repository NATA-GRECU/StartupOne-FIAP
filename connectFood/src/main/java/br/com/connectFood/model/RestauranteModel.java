package br.com.connectFood.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "T_RESTAURANTE")
public class RestauranteModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rest")
	private int id;

	@Column(name = "nm_rest", length = 60, nullable = false)
	private String nomeRestaurante;

	@Column(name = "endereco_rest", nullable = false)
	@OneToMany
	private List<AddressModel> endereco;

	@Column(name = "cnpj_rest", length = 30)
	private String cnpj;

	@Column(name = "tel_rest", length = 20)
	private String telefone;

	public RestauranteModel() {

	}

	public RestauranteModel(int id, String nomeRestaurante, String estado, String cidade, String bairro, String rua,
							String cnpj, String telefone) {
		this.id = id;
		this.nomeRestaurante = nomeRestaurante;
		this.cnpj = cnpj;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRestaurante() {
		return nomeRestaurante;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setNomeRestaurante(String nomeRestaurante) {
		this.nomeRestaurante = nomeRestaurante;
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
		return "RestauranteModel [id=" + id + ", nomeRestaurante=" + nomeRestaurante + ", cnpj=" + cnpj +
				", telefone=" + telefone + "]";
	}

}
