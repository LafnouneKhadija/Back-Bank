package pfa.museum_v1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfa.museum_v1.Entity.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {
}