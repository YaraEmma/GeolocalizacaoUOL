package br.com.geolocalizacaouol.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.geolocalizacaouol.dao.dto.ClienteDTO;
import br.com.geolocalizacaouol.dao.model.Cliente;
import br.com.geolocalizacaouol.service.ClienteService;

@RestController
@RequestMapping({"/clientes"})
public class ClienteRest {
	
	@Autowired
	private ClienteService service;

	@GetMapping
	public List<Cliente> findAll(){
	   return service.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
	   Cliente cliente = service.getCliente(id);
	   return cliente != null ? ResponseEntity.ok().body(cliente) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
    public Cliente create(@Valid @RequestBody ClienteDTO dto, HttpServletRequest request){
        return service.create(dto, request);
    }
	
	@PutMapping(value="/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteDTO dto){
		Cliente cliente = service.update(id, dto);
        return cliente != null ? ResponseEntity.ok().body(cliente) : ResponseEntity.notFound().build();
    }
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<Cliente> delete(@PathVariable("id") Long id){
		Cliente cliente = service.delete(id);
        return cliente != null ? ResponseEntity.ok().body(cliente) : ResponseEntity.notFound().build();
    }
}
