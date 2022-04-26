package com.cenfotec.examen2componentes.examen2.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreAuditoria;
    private Date fecha;

    @OneToMany(targetEntity = Cliente.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "tc_fk", referencedColumnName = "id")
    private List<Cliente> clientesList;

    public Trabajo() {
    }

    public Trabajo(Long id, String nombreAuditoria, Date fecha, List<Cliente> clientesList) {
        this.id = id;
        this.nombreAuditoria = nombreAuditoria;
        this.fecha = fecha;
        this.clientesList = clientesList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAuditoria() {
        return nombreAuditoria;
    }

    public void setNombreAuditoria(String nombreAuditoria) {
        this.nombreAuditoria = nombreAuditoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Cliente> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Cliente> clientesList) {
        this.clientesList = clientesList;
    }
}
