package com.Sunnygarden.api;

import com.Sunnygarden.common.Constants;
import com.Sunnygarden.common.RequestUltil;
import com.Sunnygarden.entity.ContactEntity;
import com.Sunnygarden.repository.ContactRepository;
import com.Sunnygarden.request.ContactRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j2
@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class ContactController {
    @Autowired
    private final JavaMailSender mailSender;
    private final ContactRepository contactRepository;

    @PostMapping(value = "/contact")
    ResponseEntity<String> registContact(@RequestBody ContactRequest request){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date currentDate = new Date();
        ContactEntity contact = new ContactEntity();
        contact.setName(RequestUltil.BlankIfNull(request.getName(),""));
        contact.setAddress(RequestUltil.BlankIfNull(request.getAddress(),""));
        contact.setEmail(RequestUltil.BlankIfNull(request.getEmail(),""));
        contact.setPhone(RequestUltil.BlankIfNull(request.getPhone(),""));
        contact.setContent(RequestUltil.BlankIfNull(request.getContent(),""));
        contact.setCreateDate(formatter.format(currentDate));
        contactRepository.save(contact);
        sendEmail(contact);
     return new ResponseEntity<>("Send success !", HttpStatus.OK);
    }
    private void sendEmail(ContactEntity contact) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(Constants.EMAIL_FROM);
        message.setTo(Constants.EMAIL_TO);
        message.setSubject("Email from "+ contact.getName());
        message.setText("Hello Joe , My Name is : "+contact.getName()+"\n"+
                                    "My Email is : "+contact.getEmail()+"\n"+
                                    "My Address is : "+contact.getAddress()+"\n"+
                                    "My Phone is : "+contact.getPhone()+"\n"+
                                    "And I want send email with purpose is : "+contact.getContent()+"\n"
                                    +" , Please contact me as soon as we can .");
        mailSender.send(message);
    }
}
