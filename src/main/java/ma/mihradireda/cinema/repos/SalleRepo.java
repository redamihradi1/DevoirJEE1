package ma.mihradireda.cinema.repos;

import ma.mihradireda.cinema.entities.Salle;
import ma.mihradireda.cinema.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalleRepo extends JpaRepository<Salle,Long> {
    Salle findByType(Type type);
    Salle findByStatut(Boolean statut);

}
