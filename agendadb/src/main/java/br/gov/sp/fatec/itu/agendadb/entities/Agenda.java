package br.gov.sp.fatec.itu.agendadb.entities;

import java.io.Serializable;
import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "agenda")
public class Agenda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String apelido;
    private String email;
    private String endereco; 
    private LocalDate aniversario;
    private String categoria;
    private boolean favorito;
    private String redes;
    private String observacoes;
    private String telefone;

    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getApelido() {
        return apelido;
    }


    public void setApelido(String apelido) {
        this.apelido = apelido;
    }



    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public LocalDate getAniversario() {
        return aniversario;
    }


    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public boolean isFavorito() {
        return favorito;
    }


    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }


    public String getredes() {
        return redes;
    }


    public void setredes(String redes) {
        this.redes = redes;
    }


    public String getObservacoes() {
        return observacoes;
    }


    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


    public String gettelefone() {
        return telefone;
    }


    public void settelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Agenda other = (Agenda) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
   
}
