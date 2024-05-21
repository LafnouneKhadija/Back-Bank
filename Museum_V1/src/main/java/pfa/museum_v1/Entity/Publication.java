package pfa.museum_v1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id_publication;


    @Temporal(TemporalType.DATE)
    private Date datePublication;

    private int nombreContenus;


    @ManyToOne
    @JoinColumn(name = "id_expert")
    private Expert expert;

    @ManyToOne
    @JoinColumn(name="id_utilisateur")
    private Utilisateur utilisateur;



}
