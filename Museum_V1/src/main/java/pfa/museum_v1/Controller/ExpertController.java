
package pfa.museum_v1.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfa.museum_v1.Entity.Expert;
import pfa.museum_v1.Service.ExpertService;

import java.util.List;

@RestController
@RequestMapping("/experts")
public class ExpertController {

    private final ExpertService expertService;

    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }

    @GetMapping
    public ResponseEntity<List<Expert>> getExperts() {
        List<Expert> experts = expertService.GetExperts();
        return new ResponseEntity<>(experts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createExpert(@RequestBody Expert expert) {
        expertService.CreateExpert(expert);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{expert_id}")
    public ResponseEntity<Void> updateExpert(@RequestBody Expert updatedExpertData, @PathVariable("expert_id") int expertId) {
        // Vérifiez si l'expert que vous voulez mettre à jour existe
        Expert existingExpert = expertService.getExpertById(expertId);
        if (existingExpert != null) {
            // Assurez-vous que l'identifiant de l'expert reste le même
            updatedExpertData.setId_expert(expertId);
            // Mettez à jour l'expert
            expertService.updateExpert(expertId, updatedExpertData);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{expert_id}")
    public ResponseEntity<Void> deleteExpert(@PathVariable("expert_id") int expertId) {
        expertService.DeleteExpert(expertId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


