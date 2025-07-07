package br.gov.sp.fatec.itu.agendadb.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.itu.agendadb.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    Optional<Agenda> findByEmailIgnoreCase(String email);

    Optional<Agenda> findByTelefone(String telefone);

}
