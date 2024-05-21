package pfa.museum_v1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfa.museum_v1.Entity.Reaction;
import pfa.museum_v1.Repository.ReactionRepo;

import java.util.List;
import java.util.Optional; 

@Service
public class ReactionService {

    @Autowired
    private final ReactionRepo reactionRepo;

    public ReactionService(ReactionRepo reactionRepo) {
        this.reactionRepo = reactionRepo;
    }

    public List<Reaction> GetReactions() {
        return reactionRepo.findAll();
    }

    public void CreateReaction(Reaction reaction)
    {
        reactionRepo.save(reaction);
    }
    // Update an existing Reaction
    public Reaction updateReaction(int idc , Reaction updatedObject) {
        Optional <Reaction> existingObject = reactionRepo.findById(idc);
        if (existingObject.isPresent())
        {
            Reaction currentObject = existingObject.get();
            currentObject.setPublication(updatedObject.getPublication());
            currentObject.setUtilisateur(updatedObject.getUtilisateur());
            currentObject.setReactionx(updatedObject.getReactionx());
            return reactionRepo.save(currentObject);
        }
        else
        {
            return null;
        }
    }

    public void DeleteReaction(int id_reaction) {
        reactionRepo.deleteById(id_reaction);
    }
}

