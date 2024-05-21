package pfa.museum_v1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reaction ;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    private String reactionx;

    @ManyToOne
    @JoinColumn(name = "id_publication")
    private Publication publication;


}
