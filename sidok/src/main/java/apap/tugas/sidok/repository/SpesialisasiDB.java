package apap.tugas.sidok.repository;

import apap.tugas.sidok.model.SpesialisasiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpesialisasiDB extends JpaRepository<SpesialisasiModel, Long>{
//    List<SpesialisasiModel> findByDokter(Long idDokter);
}
