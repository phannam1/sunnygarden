package com.Sunnygarden.api;

import com.Sunnygarden.common.RequestUltil;
import com.Sunnygarden.dto.InformationDTO;
import com.Sunnygarden.entity.InformationEntity;
import com.Sunnygarden.repository.ContactRepository;
import com.Sunnygarden.repository.InformationRepository;
import com.Sunnygarden.response.InformationResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class InformationController {

    private final InformationRepository informationRepository;

    @GetMapping(value = "/information")
    public ResponseEntity<InformationResponse> information(){
        List<InformationEntity> informationEntities = informationRepository.findAll();
        InformationResponse response = new InformationResponse();
        response.setInformations(informationEntities.stream()
            .map(infor->InformationDTO.builder()
                .icon(RequestUltil.BlankIfNull(infor.getIcon(),""))
                .link(RequestUltil.BlankIfNull(infor.getLink(),""))
                .name(RequestUltil.BlankIfNull(infor.getName(),"")).build())
            .collect(Collectors.toList()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
