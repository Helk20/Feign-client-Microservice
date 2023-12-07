package org.ensaj.voiture.Repository;

import feign.Param;
import org.ensaj.voiture.Model.Voiture;
import org.ensaj.voiture.beans.clientbeans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    // Add a new method to retrieve the name and surname of a client by the ID of a bought car

    @GetMapping("/car/{id}")
    Voiture getVoitureById(@PathVariable Long id);
    @Query("SELECT v.matricule FROM Voiture v WHERE v.id_client = :clientId")
    String getVoitureByIdClient(@PathVariable Long clientId);
    @GetMapping("/carr/{id}")
    Voiture getVoitureeById(@PathVariable Long id);
 //   @GetMapping("/client/car/{id}")
  //  clientbeans getClientByCar(@PathVariable Long id);

}
