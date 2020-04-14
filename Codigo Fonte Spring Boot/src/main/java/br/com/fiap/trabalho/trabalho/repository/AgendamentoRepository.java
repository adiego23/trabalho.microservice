package br.com.fiap.trabalho.trabalho.repository;

import br.com.fiap.trabalho.trabalho.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
}
