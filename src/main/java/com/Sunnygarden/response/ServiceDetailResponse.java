package com.Sunnygarden.response;

import com.Sunnygarden.entity.ServiceDetailEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDetailResponse {

    private List<ServiceDetailEntity> serviceDetails;
}
