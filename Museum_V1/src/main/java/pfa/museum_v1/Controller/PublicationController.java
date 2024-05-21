package pfa.museum_v1.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfa.museum_v1.Entity.Publication;
import pfa.museum_v1.Service.PublicationService;

import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationController {

    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping
    public ResponseEntity<List<Publication>> getPublications() {
        List<Publication> publications = publicationService.GetPublications();
        return new ResponseEntity<>(publications, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createPublication(@RequestBody Publication publication) {
        publicationService.CreatePublication(publication);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{publication_id}")
    public ResponseEntity<Void> updatePublication(@PathVariable("publication_id") int publicationId, @RequestBody Publication updatedPublicationData) {
        publicationService.updatePublication(publicationId, updatedPublicationData);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{publication_id}")
    public ResponseEntity<Publication> updatePublicationWithIdFirst(@PathVariable int publicationId, @RequestBody Publication updatedPublicationData) {
        Publication updatedPublication = publicationService.updatePublication(publicationId, updatedPublicationData);
        if (updatedPublication != null) {
            return ResponseEntity.ok(updatedPublication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{publication_id}")
    public ResponseEntity<Void> deletePublication(@PathVariable("publication_id") int publicationId) {
        publicationService.DeletePublication(publicationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
