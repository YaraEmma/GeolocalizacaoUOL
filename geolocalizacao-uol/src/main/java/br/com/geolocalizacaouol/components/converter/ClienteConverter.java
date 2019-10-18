package br.com.geolocalizacaouol.components.converter;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.geolocalizacaouol.dao.dto.ClienteDTO;
import br.com.geolocalizacaouol.dao.model.Cliente;
import br.com.geolocalizacaouol.service.LocalizacaoService;

public class ClienteConverter {
	
	@Autowired
	private LocalizacaoService localizacaoService;

	public Cliente toEntidade(ClienteDTO dto) {
		Cliente entidade = new Cliente();
		entidade.setNome(dto.getNome());
		entidade.setIdade(dto.getIdade());
		entidade.setLocalizacao(localizacaoService.findById(dto.getIdLocalizacao()));
		return entidade;
	}

	

}
