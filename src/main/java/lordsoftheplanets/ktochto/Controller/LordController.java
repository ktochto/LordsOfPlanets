package lordsoftheplanets.ktochto.Controller;

import lordsoftheplanets.ktochto.Model.Lord;
import lordsoftheplanets.ktochto.Repository.LordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class LordController {

    private final LordRepository lordRepository;

    @Autowired
    public LordController(LordRepository lordRepository) {
        this.lordRepository = lordRepository;
    }

    @GetMapping("/lord-list")
    public String findAll(Model model) {
        model.addAttribute("lords", lordRepository.findAll());
        return "lord-list";
    }

    @GetMapping("/lord-create")
    public String createLordForm(Lord lord) {
        return "lord-create";
    }

    @PostMapping("/lord-create")
    public String createLord(@Valid Lord lord, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "lord-create";
        }
        lordRepository.save(lord);
        return "redirect:/lord-list";
    }

    @GetMapping("/lord-delete/{id}")
    public String deleteLord(@PathVariable("id") Long id, Model model) {
        Lord lord = lordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        lordRepository.delete(lord);
        return "redirect:/lord-list";
    }

    @RequestMapping("/top")
    public String filterTopYoungest(Model model) {
        model.addAttribute("lords", lordRepository.findTopYoungest());
        return "lord-list";
    }

    @RequestMapping("/filter")
    public String filterAllNotOwners(Model model) {
        model.addAttribute("lords", lordRepository.findAllNotOwners());
        return "lord-list";
    }

}
