package br.com.geolocalizacaouol.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geolocalizacaouol.dao.model.Localizacao;

public interface ILocalizacaoRepository extends JpaRepository<Localizacao, Long>{

}