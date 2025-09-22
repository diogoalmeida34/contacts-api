package br.ifsp.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifsp.contacts.model.Contact;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Busca por nome com ignorância de maiúsculas/minúsculas
    List<Contact> findByNomeContainingIgnoreCase(String nome);
}