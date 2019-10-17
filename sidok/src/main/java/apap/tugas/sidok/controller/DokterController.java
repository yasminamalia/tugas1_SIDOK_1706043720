package apap.tugas.sidok.controller;

import apap.tugas.sidok.model.DokterModel;
import apap.tugas.sidok.model.SpesialisasiModel;
import apap.tugas.sidok.repository.DokterDB;
import apap.tugas.sidok.service.DokterService;
import apap.tugas.sidok.service.SpesialisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Controller
public class DokterController {
    @Qualifier("dokterServiceImpl")
    @Autowired
    private DokterService dokterService;

    @Qualifier("spesialisasiServiceImpl")
    @Autowired
    private SpesialisasiService spesialisasiService;

    @RequestMapping("/")
    public String home(Model model) {
        List<DokterModel> dokterList = dokterService.getDokterList();
        model.addAttribute("dokterList", dokterList);

        return "beranda";
    }

    //URL mapping yang digunakan untuk mengakses halaman add dokter
    @RequestMapping(value = "/dokter/tambah", method = RequestMethod.GET)
    public String addDokterFormPage(Model model){
        DokterModel newDokter = new DokterModel();
        List<SpesialisasiModel> listSpesialisasi = spesialisasiService.getSpesialisasiList();
        model.addAttribute("dokter", newDokter);
        model.addAttribute("listSpesialisasi", listSpesialisasi);

        return "form-tambah-dokter";
    }

    //URL mapping yang digunakan untuk submit form yang telah dimasukkan pada halaman tambah restoran
    @RequestMapping(value = "/dokter/tambah", method = RequestMethod.POST)
    public String addDokterSubmit(@ModelAttribute DokterModel dokter, Model model){
        String nip = dokterService.generateNip(dokter);
        dokter.setNip(nip);

        dokterService.addDokter(dokter);
        model.addAttribute("dokterNama", dokter.getNama());
        model.addAttribute("dokterNip", nip);

        return "tambah-dokter";
    }

    //URL mapping yang digunakan untuk hapus dokter
    @RequestMapping(value = "dokter/delete/{idDokter}")
    public String deleteDokter(@PathVariable Long idDokter, Model model){
        DokterModel deleteDokter = dokterService.getDokterByIdDokter(idDokter).get();
        model.addAttribute("dokter", deleteDokter.getNama());
        dokterService.deleteDokter(deleteDokter);

        return "hapus-dokter";
    }

    //URL mapping view
//    @RequestMapping(path = "/dokter/{nik}", method = RequestMethod.GET)
//    public String view(
//            //Request parameter untuk dipass
//            @RequestParam(value = "nik") String nik, Model model
//    ){
//        //Mengambil objek RestoranModel yang dituju
//        DokterModel dokter = dokterService.getDokterByNikDokter(nik).get();
//
//        List<SpesialisasiModel> spesialisasiList = spesialisasiService.getSpesialisasiList(dokter.getIdDokter());
//        dokter.setListSpesialisasi(spesialisasiList);
//
//        //Add model dokter ke "dokter" untuk dirender
//        model.addAttribute("dokter", dokter);
//        model.addAttribute("spesialisasiList", spesialisasiList);
//
//        //Return view template
//        return "view-restoran";
//    }

}

