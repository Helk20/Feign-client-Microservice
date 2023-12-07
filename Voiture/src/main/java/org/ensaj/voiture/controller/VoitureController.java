package org.ensaj.voiture.controller;


import feign.Param;
import org.ensaj.voiture.Model.Voiture;
import org.ensaj.voiture.Proxy.MicroserviceClientProxy;
import org.ensaj.voiture.Repository.VoitureRepository;
import org.ensaj.voiture.Service.VoitureService;
import org.ensaj.voiture.beans.clientbeans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()

public class VoitureController {

    @Autowired
    VoitureRepository voitureRepository;
    @Autowired
    MicroserviceClientProxy microserviceUserProxy;
    @Autowired
    VoitureService voitureService;
//lister tous les clients de microservice clients

    @GetMapping("/clients")
    public List<clientbeans> find(){
        return microserviceUserProxy.find();
    }
    // un client par id
    @GetMapping("/clients/{id}")
    clientbeans chercherUnClient(@PathVariable Long id){
        return   microserviceUserProxy.chercherUnClient(id);
    }
//retourner une voiture par id
    @GetMapping("/car/{id}")
    Voiture getVoitureById(@PathVariable Long id){


        return
                voitureRepository.getVoitureById(id);
    }
    @GetMapping("/carr/{id}")
    Voiture getVoitureeById(@PathVariable Long id){
        Voiture voiture=getVoitureById(id);
        clientbeans client=getInfoClient(voiture.getId());
        voiture.setClient(client);
        return
                voiture;
    }






    //retourner une voiture par client_id
   // @GetMapping("cc/car/{clientId}")
   // String getVoitureByIdClient(@PathVariable Long clientId) {
    // String matricule= voitureRepository.getVoitureByIdClient(clientId);
    // System.out.println(matricule);
 //  return matricule;
   // }
    //retourner les infos d'un client d'une voiture
    @GetMapping("clientInfo/{id}")
    clientbeans getInfoClient(@PathVariable Long id) {
       Voiture voiture= voitureRepository.getVoitureById(id);
        clientbeans clientInfo = microserviceUserProxy.chercherUnClient(voiture.getId_client());
        return clientInfo;
    }

    //@GetMapping("/client/car/{id}")
  //  clientbeans getClientByCar(@PathVariable Long id){


  //  }











}
