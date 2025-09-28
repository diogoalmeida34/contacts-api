package br.ifsp.contacts.controller;

import br.ifsp.contacts.dto.AddressDTO;
import br.ifsp.contacts.service.AddressService;
import br.ifsp.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/addresses")
@Tag(name = "Addresses", description = "Gerenciamento de endereços")
public class AddressController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/contacts/{contactId}")
    @Operation(summary = "Lista endereços de um contato", description = "Retorna os endereços vinculados a um contato específico")
    public Page<AddressDTO> getAddressesByContact(
            @PathVariable Long contactId,
            Pageable pageable) {
        return contactService.getAddressesByContact(contactId, pageable);
    }

    @GetMapping
    @Operation(summary = "Lista todos os endereços", description = "Retorna todos os endereços cadastrados no sistema")
    public Page<AddressDTO> getAllAddresses(Pageable pageable) {
        return addressService.getAllAddresses(pageable);
    }

    @PostMapping("/contacts/{contactId}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria endereço para um contato", description = "Adiciona um novo endereço vinculado a um contato")
    public AddressDTO createAddress(@PathVariable Long contactId, @RequestBody @Valid AddressDTO addressDTO) {
        return addressService.createAddress(contactId, addressDTO);
    }
}
