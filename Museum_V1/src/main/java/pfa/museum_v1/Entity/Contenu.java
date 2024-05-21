package pfa.museum_v1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contenu; 

    @ManyToOne
    @JoinColumn(name="id_publication")
    private Publication publication;

    private String contenux;
}
