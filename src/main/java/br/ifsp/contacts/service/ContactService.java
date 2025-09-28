package br.ifsp.contacts.service;

import br.ifsp.contacts.dto.ContactDTO;
import br.ifsp.contacts.dto.AddressDTO;
import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.ContactRepository;
import br.ifsp.contacts.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressService addressService;

    // Converte a entidade Contact para DTO
    private ContactDTO convertToContactDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contact.getId());
        contactDTO.setNome(contact.getNome());
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setTelefone(contact.getTelefone());

        contactDTO.setAddresses(contact.getAddresses().stream()
                .map(addressService::convertToAddressDTO)
                .collect(Collectors.toList()));

        return contactDTO;
    }

    // Converte DTO para entidade
    private Contact convertToContactEntity(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setNome(contactDTO.getNome());
        contact.setEmail(contactDTO.getEmail());
        contact.setTelefone(contactDTO.getTelefone());

        contact.setAddresses(contactDTO.getAddresses().stream()
                .map(addressService::convertToAddress)
                .collect(Collectors.toList()));

        return contact;
    }

    // Retorna todos os contatos (paginado)
    public Page<ContactDTO> getAllContacts(Pageable pageable) {
        return contactRepository.findAll(pageable).map(this::convertToContactDTO);
    }

    // Retorna contato por ID
    public ContactDTO getContactById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado: " + id));
        return convertToContactDTO(contact);
    }

    // Cria contato
    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = convertToContactEntity(contactDTO);
        contact = contactRepository.save(contact);
        return convertToContactDTO(contact);
    }

    // Atualiza contato (PUT)
    public ContactDTO updateContact(Long id, ContactDTO updatedContactDTO) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado: " + id));

        existingContact.setNome(updatedContactDTO.getNome());
        existingContact.setEmail(updatedContactDTO.getEmail());
        existingContact.setTelefone(updatedContactDTO.getTelefone());
        existingContact.setAddresses(updatedContactDTO.getAddresses().stream()
                .map(addressService::convertToAddress)
                .collect(Collectors.toList()));

        contactRepository.save(existingContact);
        return convertToContactDTO(existingContact);
    }

    // Deleta contato
    public void deleteContact(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new ResourceNotFoundException("Contato não encontrado: " + id);
        }
        contactRepository.deleteById(id);
    }

    // Busca por nome (paginado)
    public Page<ContactDTO> searchContactsByName(String name, Pageable pageable) {
        return contactRepository.findByNomeContainingIgnoreCase(name, pageable)
                .map(this::convertToContactDTO);
    }

    // Endereços de um contato (paginado)
    public Page<AddressDTO> getAddressesByContact(Long contactId, Pageable pageable) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado: " + contactId));

        return addressService.getAllAddresses(pageable)
                .map(a -> a); // Apenas repassa já convertido
    }

    // Atualização parcial (PATCH)
    public ContactDTO updatePartialContact(Long id, Map<String, Object> updates) {
        if (updates == null || updates.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma alteração informada no corpo da requisição.");
        }

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado: " + id));

        if (updates.containsKey("nome") && updates.get("nome") != null) {
            contact.setNome(updates.get("nome").toString());
        }
        if (updates.containsKey("telefone") && updates.get("telefone") != null) {
            contact.setTelefone(updates.get("telefone").toString());
        }
        if (updates.containsKey("email") && updates.get("email") != null) {
            contact.setEmail(updates.get("email").toString());
        }

        Contact savedContact = contactRepository.save(contact);
        return convertToContactDTO(savedContact);
    }
}
