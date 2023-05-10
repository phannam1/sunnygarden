package com.Sunnygarden.common;

import org.springframework.lang.Nullable;

import java.util.Objects;

public class RequestUltil {
	public static String BlankIfNull(@Nullable String valueInput, String valueDefault){
		if(Objects.isNull(valueInput))
			return valueDefault;
		return valueInput;
	}
}
