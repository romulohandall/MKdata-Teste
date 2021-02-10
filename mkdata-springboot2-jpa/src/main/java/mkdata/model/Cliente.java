package mkdata.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente implements Serializable {

	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = true)
	private String nome;
	@Column(name = "tipo", nullable = true)
	private String tipo;
	@Column(name = "nu_Cpf", nullable = true)
	private Long nuCpf;
	@Column(name = "nu_Rg", nullable = true)
	private Long nuRg;
	@Column(name = "data_Cadastro", nullable = true)
	private Timestamp dataCadastro;
	@Column(name = "ativo", nullable = true)
	private boolean stAtivo;
	@Column(name = "email", nullable = true)
	private String email;

	@OneToMany(mappedBy = "cliente", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<Telefone> telefones ;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", nuCpf=" + nuCpf
				+ "]";
	}
	
}
