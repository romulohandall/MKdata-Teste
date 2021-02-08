package mkdata.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "telefones")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Telefone {

	@Id
	@Column(name = "id_telefone")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	@JsonIgnore
	private Cliente cliente;

	@Column(name = "nome", nullable = false)
	private Integer telefone;


	@Override
	public String toString() {
		return "Telelefone [id=" + id + ", telefone=" + telefone + "]";
	}
	
}
