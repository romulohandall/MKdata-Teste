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
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@Column(name = "telefone", nullable = false)
	private long telefone;


	@Override
	public String toString() {
		return "Telelefone [id=" + id + ", telefone=" + telefone + "]";
	}
	
}
