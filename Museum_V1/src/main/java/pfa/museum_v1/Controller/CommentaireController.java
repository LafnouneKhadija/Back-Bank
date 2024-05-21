package pfa.museum_v1.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfa.museum_v1.Entity.Commentaire;
import pfa.museum_v1.Service.CommentaireService;

import java.util.List;

@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    private final CommentaireService commentaireService;

    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @GetMapping
    public ResponseEntity<List<Commentaire>> getCommentaires() {
        List<Commentaire> commentaires = commentaireService.GetCommentaire();
        return new ResponseEntity<>(commentaires, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createCommentaire(@RequestBody Commentaire commentaire) {
        commentaireService.CreateCommentaire(commentaire);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{commentaire_id}")
    public ResponseEntity<Void> updateCommentaire(@RequestBody Commentaire commentaire, @PathVariable("commentaire_id") int commentaireId) {
        commentaireService.updateCommentaire(commentaireId ,commentaire);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{commentaire_id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable("commentaire_id") int commentaireId) {
        commentaireService.DeleteCommentaire(commentaireId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
