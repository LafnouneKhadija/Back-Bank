package pfa.museum_v1.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfa.museum_v1.Entity.Utilisateur;
import pfa.museum_v1.Service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.GetUtilisateur();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.CreateUtilisateur(utilisateur);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{utilisateur_id}")
    public ResponseEntity<Void> updateUtilisateur(@RequestBody Utilisateur utilisateur, @PathVariable("utilisateur_id") int utilisateurId) {
        utilisateurService.updateUtilisateur(utilisateurId ,utilisateur);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{utilisateur_id}")
    public ResponseEntity<Utilisateur> updateUtilisateurWithIdFirst(@PathVariable int utilisateurId, @RequestBody Utilisateur updatedUtilisateurData) {
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(utilisateurId, updatedUtilisateurData);
        if (updatedUtilisateur != null) {
            return ResponseEntity.ok(updatedUtilisateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{utilisateur_id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable("utilisateur_id") int utilisateurId) {
        utilisateurService.DeleteUtilisateur(utilisateurId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
