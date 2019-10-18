package br.com.geolocalizacaouol.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import br.com.geolocalizacaouol.components.converter.ClienteConverter;
import br.com.geolocalizacaouol.dao.dto.ClienteDTO;
import br.com.geolocalizacaouol.dao.model.Cliente;
import br.com.geolocalizacaouol.dao.repository.IClienteRepository;

@Service
public class ClienteService {

	private IClienteRepository repository;
	
	private ClienteConverter converter;

	public ClienteService(IClienteRepository clienteRepository) {
		this.repository = clienteRepository;
	}
	
	public Cliente create(ClienteDTO dto, HttpServletRequest request) {
		validarCliente(dto);
		getIPCliente(request);
		Cliente cliente = converter.toEntidade(dto);
		return repository.save(cliente);
	}

	private void getIPCliente(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		System.out.println(ipAddress);
	}

	public Cliente update(Long idCliente, ClienteDTO dto) {
		validarCliente(dto);
		Cliente cliente = getCliente(idCliente);
		cliente.setNome(dto.getNome());
		cliente.setIdade(dto.getIdade());
		return repository.save(cliente);
	}
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente delete(Long id) {
		Cliente cliente = getCliente(id);
		if(cliente == null) {
			return null;
		}
		repository.delete(cliente);
		return cliente;
	}
	
	public void validarCliente(ClienteDTO dto) {
		if(dto != null) {
			if(dto.getNome() == null) {
				throw new IllegalArgumentException("Campo NOME é obrigatório");
			}else if(dto.getIdade() == null) {
				throw new IllegalArgumentException("Campo IDADE é obrigatório");
			}
		}
	}
	
	public Cliente getCliente(Long idCliente) {
		return repository.findById(idCliente)
		           .map(response -> response)
		           .orElse(null);
	}
}
