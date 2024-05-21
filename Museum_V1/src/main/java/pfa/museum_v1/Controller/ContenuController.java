package pfa.museum_v1.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfa.museum_v1.Entity.Contenu;
import pfa.museum_v1.Service.ContenuService;

import java.util.List;

@RestController
@RequestMapping("/contenus")
public class ContenuController {

    private final ContenuService contenuService;

    public ContenuController(ContenuService contenuService) {
        this.contenuService = contenuService;
    }

    @GetMapping
    public ResponseEntity<List<Contenu>> getContenus() {
        List<Contenu> contenus = contenuService.GetContenu();
        return new ResponseEntity<>(contenus, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createContenu(@RequestBody Contenu contenu) {
        contenuService.CreateContenu(contenu);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{contenu_id}")
    public ResponseEntity<Void> updateContenu(@RequestBody Contenu contenu, @PathVariable("contenu_id") int contenuId) {
        contenuService.updateContenu(contenuId ,contenu);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{contenu_id}")
    public ResponseEntity<Void> deleteContenu(@PathVariable("contenu_id") int contenuId) {
        contenuService.DeleteContenu(contenuId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
