package org.ENSAJ;

import org.ENSAJ.Model.Client;
import org.ENSAJ.Model.Voiture;
import org.ENSAJ.Repository.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@EnableFeignClients
@SpringBootApplication
public class VoitureApplication {

	private final VoitureRepository voitureRepository;
	private final ClientService clientService;

	public VoitureApplication(VoitureRepository voitureRepository, ClientService clientService) {
		this.voitureRepository = voitureRepository;
		this.clientService = clientService;
	}

	public static void main(String[] args) {
		SpringApplication.run(VoitureApplication.class, args);
	}

	@FeignClient(name = "SERVICE-CLIENT")
	interface ClientService {
		@GetMapping(path = "/clients/{id}")
		Client clientById(@PathVariable Long id);
	}

	@Transactional
	@Bean
	CommandLineRunner initializeDatabase(VoitureRepository voitureRepository, ClientService clientService) {
		return args -> {
			Client c1 = clientService.clientById(2L);
			Client c2 = clientService.clientById(1L);
			System.out.println("**************************");
			System.out.println("Id est :" + c1.getId());
			System.out.println("Nom est :" + c1.getNom());
			System.out.println("**************************");

			voitureRepository.save(new Voiture(null, "Toyota", "A 25 333", "Corolla", 1L));
			voitureRepository.save(new Voiture(null, "Renault", "B 6 3456", "Megane", 2L));
			voitureRepository.save(new Voiture(null, "Peugeot", "A 55 4444", "301", 2L));
		};
	}

}
