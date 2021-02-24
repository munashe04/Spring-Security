package com.mall.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class CartRequestDto {
	private String id;
	private String name;
	private String password;
	private String colour;
	private int numberOfWheels;
	
	
}
