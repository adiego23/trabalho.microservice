package br.com.fiap.trabalho.trabalho.service;

import br.com.fiap.trabalho.trabalho.domain.Agendamento;
import br.com.fiap.trabalho.trabalho.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agendamento")
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @GetMapping
    public List<Agendamento> listar() { return agendamentoRepository.findAll(); }

    @GetMapping("{codigo}")
    public Agendamento buscar(@PathVariable int codigo) {
        return agendamentoRepository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Agendamento cadastrar(@RequestBody Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @PutMapping("{id}")
    public Agendamento atualizar(@RequestBody Agendamento agendamento, @PathVariable int id) {
        agendamento.setCodigo(id);
        return agendamentoRepository.save(agendamento);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        agendamentoRepository.deleteById(id);
    }
}
