package apap.tugas.sidok.service;

import apap.tugas.sidok.model.DokterModel;
import apap.tugas.sidok.model.DokterModel;
import apap.tugas.sidok.repository.DokterDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class DokterServiceImpl implements DokterService{
    @Autowired
    private DokterDB dokterDB;

    @Override
    public void addDokter(DokterModel dokter) {dokterDB.save(dokter);}

    @Override
    public String generateNip(DokterModel dokter) {
        String nip = "";
        String[] hiSplit = LocalDate.now().toString().split("-");
        int todayPlusFive = Integer.parseInt(hiSplit[0]) + 5;
        nip += todayPlusFive;

        String[] tlSplit = dokter.getTanggal_lahir().toString().split("-");
        nip += tlSplit[2] + tlSplit[1] + tlSplit[0].substring(2,4);

        System.out.println(nip);

        int sex = 0;
        if(dokter.getJenis_kelamin().equals("Laki-Laki")){sex = 1;}
        if(dokter.getJenis_kelamin().equals("Perempuan")){sex = 2;}
        nip += sex;

        Random r= new Random();
        char a = (char) (r.nextInt(26) + 'A');
        char b = (char) (r.nextInt(26) + 'B');
        nip += a;
        nip += b;

        return nip;
    }

    @Override
    public List<DokterModel> getDokterList() {return dokterDB.findAll();}

    @Override
    public Optional<DokterModel> getDokterByNikDokter(String nik){
        return dokterDB.findByNik(nik);
    }

    @Override
    public Optional<DokterModel> getDokterByIdDokter(Long idDokter) {
        return dokterDB.findById(idDokter);
    }

    @Override
    public void deleteDokter(DokterModel dokter) {
        dokterDB.delete(dokter);
    }

    @Override
    public DokterModel updateDokter(DokterModel dokter) {
        return null;
    }
}
