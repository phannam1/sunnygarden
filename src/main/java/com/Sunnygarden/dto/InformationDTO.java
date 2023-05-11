package com.Sunnygarden.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InformationDTO {

    private String name;
    private String link;
    private String icon;
}
