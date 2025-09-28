package br.ifsp.contacts.controller;

import br.ifsp.contacts.dto.ContactDTO;
import br.ifsp.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/contacts")
@Validated
@Tag(name = "Contacts", description = "Gerenciamento de contatos")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    @Operation(summary = "Lista todos os contatos", description = "Retorna uma lista paginada de contatos")
    public Page<ContactDTO> getAllContacts(Pageable pageable) {
        return contactService.getAllContacts(pageable);
    }

    @GetMapping("{id}")
    @Operation(summary = "Busca um contato pelo ID", description = "Retorna os dados de um contato específico")
    public ContactDTO getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria um novo contato", description = "Cria um novo contato a partir de um DTO")
    public ContactDTO createContact(@Valid @RequestBody ContactDTO contactDTO) {
        return contactService.createContact(contactDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um contato", description = "Atualiza os dados de um contato existente")
    public ContactDTO updateContact(@PathVariable Long id,
                                    @Valid @RequestBody ContactDTO updatedContactDTO) {
        return contactService.updateContact(id, updatedContactDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta um contato", description = "Remove um contato pelo seu ID")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Busca contatos por nome", description = "Retorna contatos cujo nome contenha o termo informado")
    public Page<ContactDTO> searchContactsByName(@RequestParam String name, Pageable pageable) {
        return contactService.searchContactsByName(name, pageable);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualização parcial de contato", description = "Permite atualizar apenas alguns campos do contato")
    public ContactDTO updatePartialContact(
            @PathVariable Long id,
            @RequestBody(required = false) Map<String, Object> updates) {
        return contactService.updatePartialContact(id, updates);
    }
}
