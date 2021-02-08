package mkdata.controller;

import java.sql.Timestamp;
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

import mkdata.exception.ResourceNotFoundException;
import mkdata.model.Cliente;
import mkdata.repository.ClienteRepository;

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

		cliente.setNome(clienteDetails.getNome());
		cliente.setTipo(clienteDetails.getTipo());
		cliente.setNuCpf(clienteDetails.getNuCpf());
		cliente.setNuRg(clienteDetails.getNuRg());
		cliente.setDataCadastro(new Timestamp(System.currentTimeMillis()));
		cliente.setStAtivo(clienteDetails.isStAtivo());
		cliente.setEmail(cliente.getEmail());
		cliente.setTelefones(clienteDetails.getTelefones());

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
