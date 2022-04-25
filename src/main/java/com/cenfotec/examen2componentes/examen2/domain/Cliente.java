package com.cenfotec.examen2componentes.examen2.domain;

import java.util.List;

public class Cliente {

    private int id;
    private String razonSocial;
    private String cedula;
    private String direccion;
    private String telefono;
    private List<PersonaContacto> personaContactoList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<PersonaContacto> getPersonaContactoList() {
        return personaContactoList;
    }

    public void setPersonaContactoList(List<PersonaContacto> personaContactoList) {
        this.personaContactoList = personaContactoList;
    }
}
