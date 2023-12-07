package org.ensaj.voiture.Proxy;
import org.ensaj.voiture.beans.clientbeans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
@FeignClient(name="SERVICE-CLIENT", url="http://localhost:8080")

public interface MicroserviceClientProxy {
    @GetMapping("/clients")
    List<clientbeans> find();
    @GetMapping("/clients/{id}")
    clientbeans chercherUnClient(@PathVariable Long id);
    @GetMapping("clientInfo/{id}")
    clientbeans getInfoClient(@PathVariable Long id) ;

}
