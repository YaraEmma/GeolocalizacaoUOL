package br.com.geolocalizacaouol.dao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

	private String nome;
	private Integer idade;
	private Long idLocalizacao;
}
