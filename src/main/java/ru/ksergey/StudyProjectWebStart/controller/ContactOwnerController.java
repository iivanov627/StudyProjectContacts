package ru.ksergey.StudyProjectWebStart.controller;

import com.github.javafaker.Faker;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.ksergey.StudyProjectWebStart.common.util.ServerResponseHelper;
import ru.ksergey.StudyProjectWebStart.model.ServerResponse;
import ru.ksergey.StudyProjectWebStart.model.dto.CreateContactOwnerDto;
import ru.ksergey.StudyProjectWebStart.model.dto.UpdateContactOwnerDto;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactOwner;
import ru.ksergey.StudyProjectWebStart.model.enums.AppRole;
import ru.ksergey.StudyProjectWebStart.service.ContactOwnerService;

import java.util.*;
import java.util.stream.IntStream;

@RestController
@RequestMapping ("api/owner")
public class ContactOwnerController {

    private final ContactOwnerService contactOwnerService;

    @Autowired
    public ContactOwnerController(ContactOwnerService contactOwnerService) {
        this.contactOwnerService = contactOwnerService;
    }

    @GetMapping("/get")
    public ResponseEntity<ServerResponse<List<ContactOwner>>> getContactOwners() {

        return ServerResponseHelper.ok(contactOwnerService.getAllContactOwners());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ServerResponse<ContactOwner>> getContactOwnerById(
            @PathVariable String id
    ){

        return ServerResponseHelper.ok(contactOwnerService.getContactOwnerById(id));
    }


    @GetMapping("search")
    public ResponseEntity<ServerResponse<List<ContactOwner>>> searchContactOwner(
            @RequestParam String word
    ){
        return ServerResponseHelper.ok(contactOwnerService.searchContactOwnersByKeyword(word));
    }

    @PostMapping("create")
    public ResponseEntity<ServerResponse<ContactOwner>> createContactOwner(
          @Valid @RequestBody CreateContactOwnerDto createContactOwnerDto
    ){
       return ServerResponseHelper.created(contactOwnerService.createContactOwner(createContactOwnerDto));
    }

    @PutMapping("/update")
    public ResponseEntity<ServerResponse<ContactOwner>> updateContactOwner(
            @Valid @RequestBody UpdateContactOwnerDto updateContactOwnerDto
            ){
        return ServerResponseHelper.ok(contactOwnerService.updateContactOwner(updateContactOwnerDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServerResponse<Void>> deleteContactOwnerById(
            @PathVariable String id
    ) {
        contactOwnerService.deleteContactOwner(id);
        return ServerResponseHelper.ok(null);
    }


}
