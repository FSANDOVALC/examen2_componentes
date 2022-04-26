package com.cenfotec.examen2componentes.examen2.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String razonSocial;
    private String cedula;
    private String direccion;
    private String telefono;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")
    private List<Persona> personaContactoList;

    public Cliente() {
        super();
        personaContactoList = new ArrayList<>();
    }

    public Cliente(Long id, String razonSocial, String cedula, String direccion, String telefono, List<Persona> personaContactoList) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.personaContactoList = personaContactoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Persona> getPersonaContactoList() {
        return personaContactoList;
    }

    public void setPersonaContactoList(List<Persona> personaContactoList) {
        this.personaContactoList = personaContactoList;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", razonSocial='" + razonSocial + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", personaContactoList=" + personaContactoList +
                '}';
    }
}
