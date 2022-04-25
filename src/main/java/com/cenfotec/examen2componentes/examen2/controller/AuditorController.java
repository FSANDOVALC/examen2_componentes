package com.cenfotec.examen2componentes.examen2.controller;

import com.cenfotec.examen2componentes.examen2.domain.Auditor;
import com.cenfotec.examen2componentes.examen2.service.AuditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping({"/auditors"})
public class AuditorController {

    @Autowired
    AuditorService auditorService;

    @RequestMapping(value = "/agregarAuditor", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        model.addAttribute(new Auditor());
        return "agregarAuditor";
    }

    @RequestMapping(value = "/agregarAuditor", method = RequestMethod.POST)
    public String accionPaginaInsertar(Auditor auditor, BindingResult result, Model model){
        auditor.setFechaNacimiento(Date.from(Instant.now()));
        auditorService.saveAuditor(auditor);
        return "exito";
    }

    @RequestMapping(value = "/listarAuditores", method = RequestMethod.GET)
    public String listarAuditores(Model model){
        model.addAttribute("auditor", auditorService.getAll());
        return "listarAuditores";
    }

    @GetMapping(value ="/lista", produces = "application/json")
    public @ResponseBody
    List getAll() {
        return auditorService.getAll();
    }

}
