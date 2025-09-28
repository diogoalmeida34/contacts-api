package br.ifsp.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.ifsp.contacts.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Busca endereços de um contato específico, mas paginados
    Page<Address> findByContactId(Long contactId, Pageable pageable);
}
