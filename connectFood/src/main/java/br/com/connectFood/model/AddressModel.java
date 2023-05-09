package br.com.connectFood.model;

import javax.persistence.*;

@Entity
@Table(name = "T_ADDRESS")
public class AddressModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private int id;

    @Column(name = "estado_address", length = 40, nullable = false)
    private String estado;

    @Column(name = "cidade_address", length = 40, nullable = false)
    private String cidade;

    @Column(name = "bairro_address", length = 40, nullable = false)
    private String bairro;

    @Column(name = "rua_address", length = 100, nullable = false)
    private String rua;

    @Column(name = "nm_address", length = 100, nullable = false)
    private String numero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
