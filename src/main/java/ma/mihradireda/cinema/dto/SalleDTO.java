package ma.mihradireda.cinema.dto;

import lombok.Data;
import ma.mihradireda.cinema.enums.Type;

@Data
public class SalleDTO {

    private String nom;
    private String adresse;
    private Boolean statut;
    private Type type;
}
