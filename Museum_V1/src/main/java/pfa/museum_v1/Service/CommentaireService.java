package pfa.museum_v1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfa.museum_v1.Entity.Commentaire;
import pfa.museum_v1.Repository.CommentaireRepo;

import java.util.List;
import java.util.Optional;
@Service
public class CommentaireService {

    @Autowired
    private final CommentaireRepo commentaireRepo;

    public CommentaireService(CommentaireRepo commentaireRepo) {
        this.commentaireRepo = commentaireRepo;
    }

    public List<Commentaire> GetCommentaire() {
        return commentaireRepo.findAll();
    }
    public void CreateCommentaire(Commentaire commentaire)
    { 
        commentaireRepo.save(commentaire);
    }

    public Commentaire updateCommentaire(int idc , Commentaire updatedObject) {
        Optional <Commentaire> existingObject = commentaireRepo.findById(idc);
        if (existingObject.isPresent())
        {
            Commentaire currentObject = existingObject.get();
            currentObject.setCommentairex(updatedObject.getCommentairex());
            currentObject.setPublication(updatedObject.getPublication());
            currentObject.setUtilisateur(updatedObject.getUtilisateur());
            return commentaireRepo.save(currentObject);
        }
        else
        {
            return null;
        }
    }

    public void DeleteCommentaire(int id_commentaire) {
        commentaireRepo.deleteById(id_commentaire);
    }





}
