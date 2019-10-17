package apap.tugas.sidok.controller;

import apap.tugas.sidok.model.PoliModel;
import apap.tugas.sidok.service.PoliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PoliController {
    @Qualifier("poliServiceImpl")
    @Autowired
    private PoliService poliService;

    @RequestMapping("/poli")
    public String home(Model model) {
        List<PoliModel> poliList = poliService.getPoliList();
        model.addAttribute("poliList", poliList);

        return "daftar-poli";
    }
}
