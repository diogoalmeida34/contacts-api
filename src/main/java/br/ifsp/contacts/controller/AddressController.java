package br.ifsp.contacts.controller;

import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.AddressRepository;
import br.ifsp.contacts.repository.ContactRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import br.ifsp.contacts.exceptions.ResourceNotFoundException;


@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/contacts/{contactId}")
    public List<Address> getAddressesByContact(@PathVariable Long contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado: " + contactId));

        return contact.getAddresses();
    }

    @PostMapping("/contacts/{contactId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Address createAddress(@PathVariable Long contactId, @RequestBody @Valid Address address) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado: " + contactId));


        contact.getAddresses().add(address);

        address.setContact(contact);

        return addressRepository.save(address);
    }
}
