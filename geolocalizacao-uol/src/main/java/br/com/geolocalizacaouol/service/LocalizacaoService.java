package br.com.geolocalizacaouol.service;

import org.springframework.stereotype.Service;

import br.com.geolocalizacaouol.dao.model.Localizacao;
import br.com.geolocalizacaouol.dao.repository.ILocalizacaoRepository;

@Service
public class LocalizacaoService {

	private ILocalizacaoRepository repository;

	public LocalizacaoService(ILocalizacaoRepository localizacaoRepository) {
		this.repository = localizacaoRepository;
	}
	
	public Long create(Localizacao localizacao) {
		return null;
	}
	
	public Localizacao findById(Long idLocalizacao) {
		return repository.findById(idLocalizacao)
		           .map(response -> response)
		           .orElse(null);
	}
}
