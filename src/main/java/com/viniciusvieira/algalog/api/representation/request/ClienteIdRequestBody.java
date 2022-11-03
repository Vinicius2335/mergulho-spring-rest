package com.viniciusvieira.algalog.api.representation.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteIdRequestBody {
	@NotNull
	private Long id;
}
