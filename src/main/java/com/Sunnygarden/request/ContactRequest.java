package com.Sunnygarden.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactRequest {
	private String email;
	private String address;
	private String phone;
	private String content;
}
