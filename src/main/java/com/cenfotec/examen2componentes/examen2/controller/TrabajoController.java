package com.cenfotec.examen2componentes.examen2.controller;

import com.cenfotec.examen2componentes.examen2.domain.Cliente;
import com.cenfotec.examen2componentes.examen2.domain.Trabajo;
import com.cenfotec.examen2componentes.examen2.service.TrabajoService;
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
@RequestMapping({"/trabajos"})
public class TrabajoController {

    @Autowired
    TrabajoService trabajoService;

    @RequestMapping(value = "/registrarTrabajo", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        model.addAttribute("trabajo",new Trabajo());
        model.addAttribute("cliente",new Cliente());
        return "registrarTrabajo";
    }

    @RequestMapping(value = "/registrarTrabajo", method = RequestMethod.POST)
    public String accionPaginaInsertar(Trabajo trabajo, Cliente cliente, BindingResult result, Model model){
        trabajoService.saveTrabajo(trabajo);
        return "exito";
    }

    @GetMapping(value ="/lista", produces = "application/json")
    public @ResponseBody
    List getAll() {
        return trabajoService.getAll();
    }

}
