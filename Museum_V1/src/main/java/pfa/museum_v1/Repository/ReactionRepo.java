package pfa.museum_v1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfa.museum_v1.Entity.Reaction;

public interface ReactionRepo extends JpaRepository<Reaction,Integer> {
}
