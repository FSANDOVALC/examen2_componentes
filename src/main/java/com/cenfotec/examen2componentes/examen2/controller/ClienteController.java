package com.cenfotec.examen2componentes.examen2.controller;

import com.cenfotec.examen2componentes.examen2.domain.Cliente;
import com.cenfotec.examen2componentes.examen2.domain.Persona;
import com.cenfotec.examen2componentes.examen2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping({"/clientes"})
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    Cliente cliente;

    @RequestMapping(value = "/registrarCliente", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        model.addAttribute("cliente",new Cliente());
        model.addAttribute("persona",new Persona());
        return "registrarCliente";
    }

    @RequestMapping(value = "/registrarCliente", method = RequestMethod.POST)
    public String accionPaginaInsertar(Cliente cliente, Persona persona, BindingResult result, Model model){
        clienteService.saveCliente(cliente);
        return "exito";
    }

    @RequestMapping(value = "/listarClientes", method = RequestMethod.GET)
    public String listarClientes(Model model){
        model.addAttribute("cliente", clienteService.getAll());
        return "listarClientes";
    }

    @GetMapping(value ="/lista", produces = "application/json")
    public @ResponseBody
    List getAll() {
        return clienteService.getAll();
    }

}
