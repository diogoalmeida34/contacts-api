package br.ifsp.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.ifsp.contacts.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Busca por nome com ignorância de maiúsculas/minúsculas, mas paginado
    Page<Contact> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
