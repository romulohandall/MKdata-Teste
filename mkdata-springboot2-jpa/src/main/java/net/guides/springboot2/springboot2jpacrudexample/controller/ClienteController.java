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
	private ClienteRepository employeeRepository;

	@GetMapping("/clientes")
	public List<Cliente> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Cliente cliente = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("cliente not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(cliente);
	}

	@PostMapping("/clientes")
	public Cliente createEmployee(@Valid @RequestBody Cliente cliente) {

		return employeeRepository.save(cliente);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateEmployee(@PathVariable(value = "id") Long employeeId,
												  @Valid @RequestBody Cliente employeeDetails) throws ResourceNotFoundException {
		Cliente cliente = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("cliente not found for this id :: " + employeeId));

		cliente.setEmailId(employeeDetails.getEmailId());
		cliente.setLastName(employeeDetails.getLastName());
		cliente.setFirstName(employeeDetails.getFirstName());
		final Cliente updatedEmployee = employeeRepository.save(cliente);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/clientes/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Cliente cliente = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("cliente not found for this id :: " + employeeId));

		employeeRepository.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
