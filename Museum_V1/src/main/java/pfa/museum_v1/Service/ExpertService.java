package pfa.museum_v1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfa.museum_v1.Entity.Expert;
import pfa.museum_v1.Repository.ExpertRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ExpertService {

    @Autowired
    private final ExpertRepo expertRepo;

    public ExpertService(ExpertRepo expertRepo) {
        this.expertRepo = expertRepo;
    }

    public List<Expert> GetExperts() {
        return expertRepo.findAll();
    }

    public void CreateExpert(Expert expert)
    {
        expertRepo.save(expert);
    }

    public Expert updateExpert(int idc , Expert updatedObject) {
        Optional <Expert> existingObject = expertRepo.findById(idc);
        if (existingObject.isPresent())
        {
            Expert currentObject = existingObject.get();
            currentObject.setId_expert(updatedObject.getId_expert());
            currentObject.setDate_creation(updatedObject.getDate_creation());
            currentObject.setUsername(updatedObject.getUsername());
            currentObject.setTelephone(updatedObject.getTelephone());
            currentObject.setEmail(updatedObject.getEmail());
            currentObject.setMot_de_passe(updatedObject.getMot_de_passe());
            return expertRepo.save(currentObject);
        }
        else
        {
            return null;
        }
    }
    public void DeleteExpert(int id_expert) {
        expertRepo.deleteById(id_expert);
    }

    public Expert getExpertById(int expertId) {
   return expertRepo.findById(expertId).get(); }
}


