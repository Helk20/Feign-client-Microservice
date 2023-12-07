# Clients-Voiture-Microservice
Ce projet vise à développer une compréhension approfondie de l'architecture micro-service. Les axes centraux de cet apprentissage englobent la création et l'enregistrement de micro-services, la connexion à une base de données MySQL, l'établissement d'un micro-service Gateway, et l'implémentation d'une communication synchrone entre les micro-services en utilisant l'outil OPENFEIGN
## Architecture
![archi](https://github.com/Helk20/Feign-client-Microservice/assets/92260626/e8642a3c-ee6a-412b-abfc-16d405cd57c1)
# Requirements 
Docker + Java 17
# Etapes
## I-Création du service discovery Eureka
Eureka est un service de découverte de microservices développé par Netflix et fait partie du projet Spring Cloud. Son objectif principal est de faciliter la gestion dynamique des instances de services dans un environnement distribué de microservices.
On peut visualiser son interface en visitant : http://localhost:8761/
![Capture d'écran 2023-12-07 171816](https://github.com/Helk20/Feign-client-Microservice/assets/92260626/594197b2-78fa-4b25-a281-2df827fb6906)
## II-Création du service Gateway
La création d'un service Gateway est une étape courante dans le développement d'architectures de microservices, où un service de passerelle (Gateway) joue le rôle d'entrée principale pour les requêtes clientes. Le service Gateway peut gérer des fonctionnalités telles que l'acheminement des requêtes vers les services appropriés, l'équilibrage de charge, l'authentification, l'autorisation, la mise en cache, etc.
Il faut activer la découverte des services dans la Gateway en utilisant l'annotation @EnableDiscoveryClient
## III-Création du service Client
Pour démontrer la communication entre les services en proceder par la creation du service Client avec les attributs Id , nom et age en utilisant les depandances suivantes :
@Spring Boot Actuator Prend en charge les points de terminaison intégrés (ou personnalisés) qui vous permettent de surveiller et de gérer votre application - comme la santé de l'application, les mesures, les sessions, etc.
@Eureka Discovry Client il se base sur REST pour localiser des services dans le but d'équilibrer la charge et le basculement des serveurs intermédiaires.
@Spring Data JPA Persistance des données SQL avec l'API qui permet aux développeurs d'organiser des données relationnelles dans des applications utilisant la plateforme Java en se basant sur Spring Data et Hibernate.
@Spring Web pour créer des applications web en utilisant Spring MVC. Il utilise Apache Tomcat comme conteneur intégré par défaut.
@Spring Boot Devtools Offre des redémarrages rapides des applications, LiveReload, et des configurations pour une expérience de développement améliorée.
@Rest Repositories Expose les JPA repositorie sur REST via Spring Data REST.
@Lombok Bibliothèque d'annotation Java qui permet de réduire le code passe-partout.

On peut visualiser les client en visitant : http://localhost:8088/clients comme suit :

![Capture d'écran 2023-12-07 172653](https://github.com/Helk20/Feign-client-Microservice/assets/92260626/6fd94db8-cc56-46db-bdae-31a7da605cfd)
## IV-Création du service Voiture 
On crée un service de voiture avec les mêmes dépendances que le service client 
Dans le code, nous avons défini une interface appelée ClientService qui joue le rôle d'un client Feign pour interagir avec le microservice client. Cette interface déclare des méthodes qui correspondent aux points d'extrémité du microservice client et utilise des annotations Feign pour spécifier le chemin d'accès et la méthode HTTP.
# Pour exécuter le projet, suivez les étapes suivantes :
1.Téléchargez le code source à partir du référentiel GitHub en utilisant la commande de clonage.
</br>
2.Personnalisez les configurations de base de données dans les fichiers application.properties de chaque microservice selon vos besoins.
</br>
3.Lancez l'exécution de tous les microservices nécessaires, notamment Eureka, GateWay, Client, et Voiture.
</br>
4.Verifier si les services sont enregistres sous Eureka , comme suit :
![Capture d'écran 2023-12-07 173353](https://github.com/Helk20/Feign-client-Microservice/assets/92260626/82e2afe5-67c2-406e-8552-97b426fa931a)
5.Lancer le navigateur et tester les APIs



