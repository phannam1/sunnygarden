package com.Sunnygarden.response;

import com.Sunnygarden.dto.InformationDTO;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformationResponse {

    List<InformationDTO> informations;
}

