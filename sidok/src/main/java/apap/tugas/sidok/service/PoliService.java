package apap.tugas.sidok.service;

import apap.tugas.sidok.model.PoliModel;

import java.util.List;
import java.util.Optional;

public interface PoliService {
    //Method add poli
    void addPoli(PoliModel poli);

    //Method untuk mendapatkan semua daftar poli
    List<PoliModel> getPoliList();

    //Method untuk mendapatkan dokter berdasarkan id
    Optional<PoliModel> getPoliByIdPoli(Long idPoli);
}
