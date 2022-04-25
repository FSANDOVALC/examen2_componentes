package com.cenfotec.examen2componentes.examen2.controller;

import com.cenfotec.examen2componentes.examen2.domain.Persona;
import com.cenfotec.examen2componentes.examen2.service.PersonaService;
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
@RequestMapping({"/personas"})
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @RequestMapping(value = "/registrarPersona", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        model.addAttribute(new Persona());
        return "registrarPersona";
    }

    @RequestMapping(value = "/registrarPersona", method = RequestMethod.POST)
    public String accionPaginaInsertar(Persona persona, BindingResult result, Model model){
        personaService.savePersona(persona);
        return "exito";
    }

    @GetMapping(value ="/lista", produces = "application/json")
    public @ResponseBody
    List getAll() {
        return personaService.getAll();
    }

}
