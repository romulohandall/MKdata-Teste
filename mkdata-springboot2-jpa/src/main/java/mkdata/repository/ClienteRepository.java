package mkdata.repository;

import mkdata.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    @Query(value = "SELECT c FROM Cliente c WHERE c.nome like %:nome% order by c.nome")
    List<Cliente> findByNome(@Param("nome") String nome);

    @Query(value = "SELECT c FROM Cliente c WHERE c.nuCpf = :cpf")
    Cliente findByCpf(@Param("cpf") Long cpf);



}
