package hiragi.innovatracker.repository;

import hiragi.innovatracker.model.TdDepartamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TdDepartamentoRepository extends JpaRepository<TdDepartamento, Long> {

    // Busca exata pela sigla (campo único), ignorando caixa
    Optional<TdDepartamento> findBySglDepartamentoIgnoreCase(String sglDepartamento);

    // Validação de unicidade antes de salvar
    boolean existsBySglDepartamentoIgnoreCase(String sglDepartamento);

    // Consulta aproximada por nome -> LIKE %nome% ignorando caixa
    List<TdDepartamento> findByNmeDepartamentoContainingIgnoreCase(String nmeDepartamento);

    // Versão paginada
    Page<TdDepartamento> findByNmeDepartamentoContainingIgnoreCase(String nmeDepartamento, Pageable pageable);
}