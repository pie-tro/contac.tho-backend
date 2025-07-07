package br.gov.sp.fatec.itu.agendadb.services;

import java.util.List;
import java.util.Optional; // IMPORTANT: Import Optional for repository methods

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.itu.agendadb.entities.Agenda;
import br.gov.sp.fatec.itu.agendadb.repositories.AgendaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository repository;

    public List<Agenda> getAll() {
        return repository.findAll();
    }

    public Agenda save(Agenda agenda) {
        return repository.save(agenda);
    }
    public void update(Agenda agenda, long id){
    
        Agenda aux = repository.getReferenceById(id);

        aux.setNome(agenda.getNome());
        aux.setEmail(agenda.getEmail());
        aux.setEndereco(agenda.getEndereco());
        aux.setAniversario(agenda.getAniversario());
        aux.setCategoria(agenda.getCategoria());
        aux.setFavorito(agenda.isFavorito());
        aux.setredes(agenda.getredes());
        aux.setObservacoes(agenda.getObservacoes());
        aux.settelefone(agenda.gettelefone());
         aux.setApelido(agenda.getApelido());
        repository.save(aux);
    }
    public void delete(long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Agenda não cadastrado");
        }
    }
    public boolean existsByEmail(String email, Long currentId) {
        Optional<Agenda> existingAgenda = repository.findByEmailIgnoreCase(email);
        // An email exists AND (it's a new agenda OR the existing agenda's ID is different from the current one)
        return existingAgenda.isPresent() && (currentId == null || !existingAgenda.get().getId().equals(currentId));
    }
    public boolean existsByPhone(String telefone, Long currentId) {
        Optional<Agenda> existingAgenda = repository.findByTelefone(telefone); // Assumes findByTelefone in AgendaRepository
        // A phone number exists AND (it's a new agenda OR the existing agenda's ID is different from the current one)
        return existingAgenda.isPresent() && (currentId == null || !existingAgenda.get().getId().equals(currentId));
    }
}