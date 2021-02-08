package mkdata.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "tipo", nullable = false)
	private String tipo;
	@Column(name = "nu_Cpf", nullable = false)
	private Integer nuCpf;
	@Column(name = "nu_Rg", nullable = false)
	private Integer nuRg;
	@Column(name = "data_Cadastro", nullable = false)
	private Timestamp dataCadastro;
	@Column(name = "ativo", nullable = false)
	private boolean stAtivo;
	@Column(name = "email", nullable = false)
	private String email;
	@OneToMany(mappedBy = "cliente")
	private List<Telefone> telefones ;

	

	


	

	




	@Override
	public String toString() {
		return "Employee [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", nuCpf=" + nuCpf
				+ "]";
	}
	
}
