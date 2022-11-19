package ma.mihradireda.cinema.mappers;

import ma.mihradireda.cinema.dto.SalleDTO;
import ma.mihradireda.cinema.entities.Salle;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MyMapper {
    public SalleDTO fromSalle(Salle salle){
        SalleDTO salleDTO = new SalleDTO();
        salleDTO.setNom(salle.getNom());
        salleDTO.setAdresse(salle.getAdresse());
        salleDTO.setStatut(salle.getStatut());
        salleDTO.setType(salle.getType());
        return salleDTO;
    }

    public Salle fromSalleDTO(SalleDTO salleDTO){
        Salle salle = new Salle();
        BeanUtils.copyProperties(salleDTO,salle);
        return  salle;
    }

}
