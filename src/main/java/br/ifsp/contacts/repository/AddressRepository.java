package br.ifsp.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import br.ifsp.contacts.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByContactId(Long contactId);
}