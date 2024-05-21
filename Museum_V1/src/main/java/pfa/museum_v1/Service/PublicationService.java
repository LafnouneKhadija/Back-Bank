package pfa.museum_v1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfa.museum_v1.Entity.Publication;
import pfa.museum_v1.Repository.PublicationRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {

    @Autowired 
    private final PublicationRepo publicationRepo;

    public PublicationService(PublicationRepo publicationRepo) {
        this.publicationRepo = publicationRepo;
    }

    public List<Publication> GetPublications() {
        return publicationRepo.findAll();
    }

    public void CreatePublication(Publication publication)
    {
        publicationRepo.save(publication);
    }

    public Publication updatePublication(int idc , Publication updatedObject) {
        Optional <Publication> existingObject = publicationRepo.findById(idc);
        if (existingObject.isPresent())
        {
            Publication currentObject = existingObject.get();
            currentObject.setExpert(updatedObject.getExpert());
            currentObject.setUtilisateur(updatedObject.getUtilisateur());
            currentObject.setDatePublication(updatedObject.getDatePublication());
            currentObject.setNombreContenus(updatedObject.getNombreContenus());
            return publicationRepo.save(currentObject);
        }
        else
        {
            return null;
        }
    }

    public void DeletePublication(int id_publication) {
        publicationRepo.deleteById(id_publication);
    }
}
