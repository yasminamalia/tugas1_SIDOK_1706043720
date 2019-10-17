package apap.tugas.sidok.service;

import apap.tugas.sidok.model.DokterModel;

import java.util.List;
import java.util.Optional;

public interface DokterService {
    //Method untuk menambah restoran
    void addDokter(DokterModel dokter);

    //Method untuk generate NIP
    String generateNip(DokterModel dokter);

    //Method untuk mendapatkan semua data Dokter yang tersimpan
    List<DokterModel> getDokterList();

    //Method untuk mendapatkan data seorang Dokter berdasarkan idDokter
    Optional<DokterModel> getDokterByNikDokter(String nik);

    //Method untuk mendapatkan dokter berdasarkan id
    Optional<DokterModel> getDokterByIdDokter(Long idDokter);

    //Method untuk menghapus dokter
    void deleteDokter (DokterModel dokter);

    DokterModel updateDokter(DokterModel dokter);
}
