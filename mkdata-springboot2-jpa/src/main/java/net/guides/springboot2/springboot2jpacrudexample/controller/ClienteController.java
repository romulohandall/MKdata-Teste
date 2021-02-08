package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Cliente;
import net.guides.springboot2.springboot2jpacrudexample.repository.ClienteRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ClienteController {
	@Autowired
	private ClienteRepository repository;

	@GetMapping("/clientes")
	public List<Cliente> getAllClientes() {
		return repository.findAll();
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getClientesById(@PathVariable(value = "id") Long idCliente)
			throws ResourceNotFoundException {
		Cliente cliente = repository.findById(idCliente)
				.orElseThrow(() -> new ResourceNotFoundException("cliente not found for this id :: " + idCliente));
		return ResponseEntity.ok().body(cliente);
	}

	@PostMapping("/clientes")
	public Cliente createEmployee(@Valid @RequestBody Cliente cliente) {

		return repository.save(cliente);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateEmployee(@PathVariable(value = "id") Long idCliente,
												  @Valid @RequestBody Cliente clienteDetails) throws ResourceNotFoundException {
		Cliente cliente = repository.findById(idCliente)
				.orElseThrow(() -> new ResourceNotFoundException("cliente not found for this id :: " + idCliente));

		cliente.setEmailId(clienteDetails.getEmailId());
		cliente.setLastName(clienteDetails.getLastName());
		cliente.setFirstName(clienteDetails.getFirstName());
		final Cliente updatedEmployee = repository.save(cliente);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/clientes/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long idCliente)
			throws ResourceNotFoundException {
		Cliente cliente = repository.findById(idCliente)
				.orElseThrow(() -> new ResourceNotFoundException("cliente not found for this id :: " + idCliente));

		repository.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
