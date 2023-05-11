package com.Sunnygarden.api;

import com.Sunnygarden.common.RequestUltil;
import com.Sunnygarden.entity.ContactEntity;
import com.Sunnygarden.repository.ContactRepository;
import com.Sunnygarden.request.ContactRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class ContactController {

    private final ContactRepository contactRepository;

    @PostMapping(value = "/contact")
    ResponseEntity<String> registContact(@RequestBody ContactRequest request){
        ContactEntity contact = new ContactEntity();
        contact.setAddress(RequestUltil.BlankIfNull(request.getAddress(),""));
        contact.setEmail(RequestUltil.BlankIfNull(request.getEmail(),""));
        contact.setPhone(RequestUltil.BlankIfNull(request.getPhone(),""));
        contact.setContent(RequestUltil.BlankIfNull(request.getContent(),""));
        contactRepository.save(contact);
     return new ResponseEntity<>("Send success !", HttpStatus.OK);
    }
}
