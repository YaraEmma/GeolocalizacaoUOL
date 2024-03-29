package br.com.geolocalizacaouol.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.geolocalizacaouol.dao.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{

}
