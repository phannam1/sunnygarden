package com.Sunnygarden.response;

import com.Sunnygarden.entity.ServiceEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponse {

    List<ServiceEntity> serviceEntities;
}
