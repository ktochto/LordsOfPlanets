package lordsoftheplanets.ktochto.Controller;

import lordsoftheplanets.ktochto.Model.Planet;
import lordsoftheplanets.ktochto.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PlanetController {

    private final PlanetRepository planetRepository;

    @Autowired
    public PlanetController(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @GetMapping("/planet-list")
    public String showPlanetsList(Model model) {
        model.addAttribute("planets", planetRepository.findAll());
        return "planet-list";
    }

    @GetMapping("/planet-create")
    public String createPlanetForm(Planet planet) {
        return "planet-create";
    }

    @PostMapping("/planet-create")
    public String createPlanet(@Valid Planet planet, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "planet-create";
        }
        planetRepository.save(planet);
        return "redirect:/planet-list";
    }

    @GetMapping("/planet-delete/{id}")
    public String deletePlanet(@PathVariable("id") Long id, Model model) {
        Planet planet = planetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        planetRepository.delete(planet);
        return "redirect:/planet-list";
    }

}
