package br.ifsp.contacts.service;

import br.ifsp.contacts.dto.AddressDTO;
import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.AddressRepository;
import br.ifsp.contacts.repository.ContactRepository;
import br.ifsp.contacts.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ContactRepository contactRepository;

    // Converte Address para AddressDTO
    public AddressDTO convertToAddressDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setRua(address.getRua());
        addressDTO.setCidade(address.getCidade());
        addressDTO.setEstado(address.getEstado());
        addressDTO.setCep(address.getCep());
        return addressDTO;
    }

    // Converte AddressDTO para Address
    public Address convertToAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setRua(addressDTO.getRua());
        address.setCidade(addressDTO.getCidade());
        address.setEstado(addressDTO.getEstado());
        address.setCep(addressDTO.getCep());
        return address;
    }

    // Criar um novo endereço para um contato específico
    public AddressDTO createAddress(Long contactId, AddressDTO addressDTO) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado: " + contactId));

        Address address = convertToAddress(addressDTO);
        address.setContact(contact);

        address = addressRepository.save(address);

        return convertToAddressDTO(address);
    }

    // Retorna todos os endereços do sistema (paginado)
    public Page<AddressDTO> getAllAddresses(Pageable pageable) {
        return addressRepository.findAll(pageable).map(this::convertToAddressDTO);
    }
}
