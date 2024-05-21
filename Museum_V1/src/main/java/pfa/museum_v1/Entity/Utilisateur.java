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
public class Utilisateur
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_utilisateur;

    private String username;

    private String email;

    private String mot_de_passe;

    private int telephone;

    @Column(name="dateCreation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
}
