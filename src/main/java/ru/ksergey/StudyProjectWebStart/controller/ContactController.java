package ru.ksergey.StudyProjectWebStart.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ksergey.StudyProjectWebStart.common.util.ServerResponseHelper;
import ru.ksergey.StudyProjectWebStart.model.ServerResponse;
import ru.ksergey.StudyProjectWebStart.model.dto.CreateContactDto;
import ru.ksergey.StudyProjectWebStart.model.dto.UpdateContactDto;
import ru.ksergey.StudyProjectWebStart.model.entity.Contact;
import ru.ksergey.StudyProjectWebStart.service.ContactService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/get")
    public ResponseEntity<ServerResponse<ArrayList<Contact>>> getContacts (){
        ArrayList<Contact> result = new ArrayList<>(contactService.getAllContacts());
        return ServerResponseHelper.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ServerResponse<Contact>> getContactById (@PathVariable int id){

        Contact result = contactService.getContactById(id);
        return ServerResponseHelper.ok(result);
    }

    @PostMapping("/create")
    public ResponseEntity<ServerResponse<Contact>> createContact (
         @Valid @RequestBody CreateContactDto createContactDto){

        Contact result = contactService.createContact(createContactDto);
        return ServerResponseHelper.created(result);
    }

    @PutMapping("/update")
    public ResponseEntity<ServerResponse<Contact>> updateContact(
          @Valid @RequestBody UpdateContactDto updateContactDto){

        Contact result = contactService.updateContact(updateContactDto);
        return ServerResponseHelper.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServerResponse<Void>> deleteContact (@PathVariable int id){

        contactService.deleteContact(id);
        return ServerResponseHelper.ok(null);
    }
}
