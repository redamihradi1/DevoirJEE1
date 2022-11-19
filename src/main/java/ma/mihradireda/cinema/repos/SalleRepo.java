package ma.mihradireda.cinema.repos;

import ma.mihradireda.cinema.entities.Salle;
import ma.mihradireda.cinema.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SalleRepo extends JpaRepository<Salle,Long> {
    @Query("SELECT r FROM Salle r where lower(r.type)=lower(:#{#type?.toString()}) ")
    public List<Salle> findByType(@Param("type") Type type);

    public List<Salle> findByStatutTrue();
    public  List<Salle> findByStatutFalse();
}
