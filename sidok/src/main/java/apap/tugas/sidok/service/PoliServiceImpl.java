package apap.tugas.sidok.service;

import apap.tugas.sidok.model.PoliModel;
import apap.tugas.sidok.repository.PoliDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliServiceImpl implements PoliService {
    @Autowired
    private PoliDB poliDB;

    @Override
    public void addPoli(PoliModel poli) {
        poliDB.save(poli);
    }

    @Override
    public List<PoliModel> getPoliList() {
        return poliDB.findAll();
    }

    @Override
    public Optional<PoliModel> getPoliByIdPoli(Long idPoli) {
        return poliDB.findById(idPoli);
    }
}
