package br.com.fiap.trabalho.trabalho.controller;

import br.com.fiap.trabalho.trabalho.domain.Agendamento;
import br.com.fiap.trabalho.trabalho.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;

    @GetMapping("cadastrar")
    public String abrirFormulario(Agendamento agendamento, Model model){
        //model.addAttribute("agendamento", repository.findAll());
        return "agendamento/form";
    }

    @PostMapping("cadastrar")
    public String processarForm(@Valid Agendamento agendamento, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()) {
            return "agendamento/form";
        }
        redirectAttributes.addFlashAttribute("msg", "Cadastrado!");
        repository.save(agendamento);
        return "redirect:listar";
    }
    @GetMapping("listar")
    public String listarAgendamentos(Model model){
        model.addAttribute("agendamentos", repository.findAll());
        return "agendamento/lista";
    }
    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("agendamento",repository.findById(codigo));
        return "agendamento/form";
    }
    @PostMapping("excluir")
    public String remover(int codigo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Removido!");
        repository.deleteById(codigo);
        return "redirect:listar";
    }
}
