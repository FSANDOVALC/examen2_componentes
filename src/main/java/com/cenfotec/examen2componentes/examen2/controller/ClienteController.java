package com.cenfotec.examen2componentes.examen2.controller;

import com.cenfotec.examen2componentes.examen2.domain.Cliente;
import com.cenfotec.examen2componentes.examen2.domain.Persona;
import com.cenfotec.examen2componentes.examen2.service.ClienteService;
import com.cenfotec.examen2componentes.examen2.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/clientes"})
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    PersonaService personaService;

    Cliente cliente;

    @RequestMapping(value = "/registrarCliente", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        model.addAttribute("cliente",new Cliente());
        model.addAttribute("persona",new Persona());
        return "registrarCliente";
    }

    @RequestMapping(value = "/registrarCliente", method = RequestMethod.POST)
    public String accionPaginaInsertar(Cliente cliente, BindingResult result, Model model){
        clienteService.saveCliente(cliente);
        return "exito";
    }

    @RequestMapping(value = "/registrarPersona", method = RequestMethod.GET)
    public void mostrarPersona(Model model){
        model.addAttribute(new Persona());
    }

    @RequestMapping(value = "/registrarPersona", method = RequestMethod.POST)
    public void registrarPersona(Persona persona, BindingResult result, Model model){
        Optional<Cliente> tmpCliente = clienteService.getById(Math.toIntExact(this.cliente.getId()));
        List<Persona> listPersona = new ArrayList();
        listPersona.add(persona);
        tmpCliente.get().setPersonaContactoList(listPersona);
        clienteService.saveCliente(tmpCliente.get());
    }

    @GetMapping(value ="/lista", produces = "application/json")
    public @ResponseBody
    List getAll() {
        return clienteService.getAll();
    }

}
