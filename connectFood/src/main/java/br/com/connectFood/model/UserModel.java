package br.com.connectFood.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_USER")
public class UserModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    @Column(name = "nm_user", length = 100, nullable = false)
    private String name;

    @Column(name = "ds_user", length = 255, nullable = false)
    private String description;

    @Column(name = "endereco_user", nullable = false)
    @OneToMany
    private List<AddressModel> addresses;

    @Column(name = "cnpj_user", length = 30)
    private String cnpj;

    @Column(name = "tel_user", length = 20)
    private String phone;

    @Column(name = "cell_user", length = 20)
    private String cellphone;

    @Column(name = "email_user", length = 60)
    private String email;

    @Column(name = "password_user", length = 20)
    private String password;

    @Column(name = "type_user", length = 25)
    private String type;

    private String photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressModel> addresses) {
        this.addresses = addresses;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
