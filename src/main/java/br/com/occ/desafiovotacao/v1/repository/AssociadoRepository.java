package br.com.occ.desafiovotacao.v1.repository;

import br.com.occ.desafiovotacao.v1.model.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {
    List<Associado> findAllByAtivoIs(Boolean ativo);

    boolean existsByCpf(String cpf);
}
