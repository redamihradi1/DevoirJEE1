package ma.mihradireda.cinema.controllers;

import ma.mihradireda.cinema.dto.SalleDTO;
import ma.mihradireda.cinema.entities.Salle;
import ma.mihradireda.cinema.enums.Type;
import ma.mihradireda.cinema.mappers.MyMapper;
import ma.mihradireda.cinema.repos.SalleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json",path = "salle")
public class SalleRest {

    SalleRepo salleRepo;
    @Autowired
    MyMapper myMapper;

    public SalleRest(SalleRepo salleRepo) {
        this.salleRepo = salleRepo;
    }

    // ajouter une salle
    @PostMapping("/ajouter")
    public Salle addSalle(@RequestBody Salle salle){
        System.out.println("Ajout d'une salle avec succes");
        return  salleRepo.save(salle);
    }

    // modifier une salle
    @PutMapping("/modifier/{id}")
    public Salle updateSalle(@RequestBody Salle salle,@PathVariable Long id){
        Salle s = salleRepo.findById(id).get();
        if (s != null){
            s.setNom(salle.getNom());
            s.setAdresse(salle.getAdresse());
            s.setDateCreation(salle.getDateCreation());
            s.setNbrChaise(salle.getNbrChaise());
            s.setStatut(salle.getStatut());
            s.setType(salle.getType());
            System.out.println("Modification d'une salle avec succes");
            return  salleRepo.save(s);
        }
        return null;
    }

    // supprimer une salle
    @DeleteMapping("/supprimer/{id}")
    public void deleteSalle(@PathVariable Long id){
        Salle salle = salleRepo.findById(id).get();
        if (salle != null){
            System.out.println("Suppression d'une salle avec succes");
            salleRepo.delete(salle);
        }
    }

    // afficher l'ensemble des elements
    @GetMapping("/all")
    public List<SalleDTO> getSalles(){
        List<Salle> s= salleRepo.findAll();
        List<SalleDTO> salles = new ArrayList<>();
        for (int i=0;i<s.size();i++){
            SalleDTO salleDTO = myMapper.fromSalle(s.get(i));
            salles.add(salleDTO);
        }
        System.out.println("Affichage de toute les salles avec succes");
        return salles;
    }

    // rechercher par id
    @GetMapping("/chercherparid/{id}")
    public Salle findSalleId(@PathVariable long id){
        System.out.println("fin by id d'une salle avec succes");
        return salleRepo.findById(id).get();
    }


    // chercher par type
    @GetMapping("/chercherpartype/{type}")
    public List<Salle> findSalleType(@PathVariable Type type){
        if (salleRepo.findByType(type) != null ){
            return salleRepo.findByType(type);
        }
        return null;
    }

    // chercher par statut
    @GetMapping("/chercherparstatut/{statut}")
    public List<Salle> findSalleStatut(@PathVariable Boolean statut){

        if (statut == true){
            return salleRepo.findByStatutTrue();
        }
        return salleRepo.findByStatutFalse();



    }



}
