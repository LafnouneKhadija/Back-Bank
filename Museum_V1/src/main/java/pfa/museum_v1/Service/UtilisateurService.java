package pfa.museum_v1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfa.museum_v1.Entity.Utilisateur;
import pfa.museum_v1.Repository.UtilisateurRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private final UtilisateurRepo utilisateurrepo;

    public UtilisateurService(UtilisateurRepo utilisateurrepo) {
        this.utilisateurrepo = utilisateurrepo;
    }

    public List<Utilisateur> GetUtilisateur()
    {
        return utilisateurrepo.findAll();
    }

    public void CreateUtilisateur(Utilisateur utilisateur)
    {
        utilisateurrepo.save(utilisateur);
    }

    // Update an existing Utilisateur
    public Utilisateur updateUtilisateur(int idc , Utilisateur updatedObject) {
        Optional <Utilisateur> existingObject = utilisateurrepo.findById(idc);
        if (existingObject.isPresent())
        {
            Utilisateur currentObject = existingObject.get();
            // Can't update a primary key
            currentObject.setEmail(updatedObject.getEmail());
            currentObject.setMot_de_passe(updatedObject.getMot_de_passe());
            currentObject.setTelephone(updatedObject.getTelephone());
            currentObject.setEmail(updatedObject.getEmail());
            currentObject.setUsername(updatedObject.getUsername());
            return utilisateurrepo.save(currentObject);
        }

         else
    {
        return null;
    }
}

public void DeleteUtilisateur(int utilisateur_id)
{
    utilisateurrepo.deleteById(utilisateur_id);
}
}
