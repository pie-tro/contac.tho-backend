package br.gov.sp.fatec.itu.agendadb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; // Import RequestParam
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.itu.agendadb.entities.Agenda;
import br.gov.sp.fatec.itu.agendadb.services.AgendaService;

@CrossOrigin // Consider specifying origins for production, e.g., @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("agenda")
public class AgendaController {
    
    @Autowired
    private AgendaService service;

    @GetMapping
    public ResponseEntity<List<Agenda>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Agenda> save(@RequestBody Agenda agenda){
        // The service will now handle the validation before saving
        return ResponseEntity.created(null).body(service.save(agenda));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Agenda agenda){
        service.update(agenda, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/existsByEmail")
    public ResponseEntity<Boolean> existsByEmail(@RequestParam String email, @RequestParam(required = false) Long id) {
        boolean exists = service.existsByEmail(email, id);
        return ResponseEntity.ok(exists);
    }
    @GetMapping("/existsByPhone")
    public ResponseEntity<Boolean> existsByPhone(@RequestParam String phone, @RequestParam(required = false) Long id) {
        boolean exists = service.existsByPhone(phone, id);
        return ResponseEntity.ok(exists);
    }
}