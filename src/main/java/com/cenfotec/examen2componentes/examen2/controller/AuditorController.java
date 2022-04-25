package com.cenfotec.examen2componentes.examen2.controller;

import com.cenfotec.examen2componentes.examen2.domain.Auditor;
import com.cenfotec.examen2componentes.examen2.service.AuditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "editar/{id}")
    public String irAEditar(Model model, @PathVariable int id) {
        Optional<Auditor> auditorToEdit = auditorService.getById(id);
        if (auditorToEdit.isPresent()){
            model.addAttribute("auditorToEdit", auditorToEdit);
            return "editarAuditor";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "editar/{id}", method = RequestMethod.POST)
    public String guardarCambios(Auditor auditor, BindingResult result, Model model, @PathVariable int id) {
        auditorService.updateAuditor(auditor);
        return "exito";
    }

}
