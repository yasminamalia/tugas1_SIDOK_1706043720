package apap.tugas.sidok.service;

import apap.tugas.sidok.model.SpesialisasiModel;

import java.util.List;
import java.util.Optional;

public interface SpesialisasiService {
    void addSpesialisasi(SpesialisasiModel spesialisasi);
    List<SpesialisasiModel> getSpesialisasiList();
//    List<SpesialisasiModel> getSpesialisasiDokterList(Long idDokter);
}
