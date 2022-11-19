package ma.mihradireda.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.mihradireda.cinema.enums.Type;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 30,nullable = false,unique = true)
    private  String nom;
    @Column(length = 60,nullable = false)
    private String adresse;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(nullable = false)
    private int nbrChaise;
    @Column(nullable = false)
    private Boolean statut;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;
}
