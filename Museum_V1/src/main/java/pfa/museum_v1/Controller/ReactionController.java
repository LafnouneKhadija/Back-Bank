package pfa.museum_v1.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfa.museum_v1.Entity.Reaction;
import pfa.museum_v1.Service.ReactionService;

import java.util.List;

@RestController
@RequestMapping("/reactions")
public class ReactionController {

    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @GetMapping
    public ResponseEntity<List<Reaction>> getReactions() {
        List<Reaction> reactions = reactionService.GetReactions();
        return new ResponseEntity<>(reactions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createReaction(@RequestBody Reaction reaction) {
        reactionService.CreateReaction(reaction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{reaction_id}")
    public ResponseEntity<Void> updateReaction(@PathVariable("reaction_id") int reactionId, @RequestBody Reaction updatedReactionData) {
        reactionService.updateReaction(reactionId, updatedReactionData);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{reaction_id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable("reaction_id") int reactionId) {
        reactionService.DeleteReaction(reactionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


