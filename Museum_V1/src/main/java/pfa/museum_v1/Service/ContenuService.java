package pfa.museum_v1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfa.museum_v1.Entity.Contenu;
import pfa.museum_v1.Repository.ContenuRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ContenuService {

    @Autowired
    private final ContenuRepo contenuRepo; 

    public ContenuService(ContenuRepo contenuRepo) {
        this.contenuRepo = contenuRepo;
    }

    public List<Contenu> GetContenu() {
        return contenuRepo.findAll();
    }

    public void CreateContenu(Contenu contenu)
    {
        contenuRepo.save(contenu);
    }

    public Contenu updateContenu(int idc , Contenu updatedObject) {
        Optional <Contenu> existingObject = contenuRepo.findById(idc);
        if (existingObject.isPresent())
        {
            Contenu currentObject = existingObject.get();
            currentObject.setContenux(updatedObject.getContenux());
            currentObject.setPublication(updatedObject.getPublication());
            return contenuRepo.save(currentObject);
        }
        else
        {
            return null;
        }
    }

    public void DeleteContenu(int id_contenu) {
        contenuRepo.deleteById(id_contenu);
    }
}
