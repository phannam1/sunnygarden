package com.Sunnygarden.api;

import com.Sunnygarden.entity.ServiceEntity;
import com.Sunnygarden.repository.ServiceDetailRepository;
import com.Sunnygarden.repository.ServiceRepository;
import com.Sunnygarden.response.ServiceDetailResponse;
import com.Sunnygarden.response.ServiceResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class ServiceController {

    private final ServiceRepository serviceRepository;

    private final ServiceDetailRepository serviceDetailRepository;

    @GetMapping(value = "/service")
    public ResponseEntity<ServiceResponse> services(){
        ServiceResponse serviceEntities = new ServiceResponse();
        serviceEntities.setServiceEntities(serviceRepository.findAll());
        return new ResponseEntity<>(serviceEntities, HttpStatus.OK);
    }
    @GetMapping(value = "/service-detail")
    public ResponseEntity<ServiceDetailResponse> serviceDetail(@RequestParam("serviceId") Long serviceId){
        ServiceEntity serviceEntities = new ServiceEntity();
        serviceEntities.setId(serviceId);
        ServiceDetailResponse serviceDetailResponse = new ServiceDetailResponse();
        serviceDetailResponse.setServiceDetails(serviceDetailRepository.findAllByService(serviceEntities));
        return new ResponseEntity<>(serviceDetailResponse, HttpStatus.OK);
    }

}
