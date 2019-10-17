package apap.tugas.sidok.service;

import apap.tugas.sidok.model.SpesialisasiModel;
import apap.tugas.sidok.repository.SpesialisasiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpesialisasiServiceImpl implements SpesialisasiService {
    @Autowired
    private SpesialisasiDB spesialisasiDB;

    @Override
    public void addSpesialisasi(SpesialisasiModel spesialisasi) {
        spesialisasiDB.save(spesialisasi);
    }

    @Override
    public List<SpesialisasiModel> getSpesialisasiList() {
        return spesialisasiDB.findAll();
    }

//    @Override
//    public List<SpesialisasiModel> getSpesialisasiDokterList(Long idDokter) {
//        return spesialisasiDB.findByDokter(idDokter);
//    }

}
