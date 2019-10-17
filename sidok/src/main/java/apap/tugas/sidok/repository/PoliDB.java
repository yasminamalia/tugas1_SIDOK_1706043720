package apap.tugas.sidok.repository;

import apap.tugas.sidok.model.PoliModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PoliDB extends JpaRepository<PoliModel, Long> {
    Optional<PoliModel> findById(Long idPoli);
}
