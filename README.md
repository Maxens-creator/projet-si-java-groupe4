# Projet SI Java - ESIEE‑IT (2025‑2026)

## Contexte

Projet SI en Java : construire une API backend propre, structurée, documentée et testée, avec un workflow Git proche entreprise.

## Objectifs

- Mettre en place un dépôt Git propre (main/develop/feature)
- Implémenter un MVP (auth + gestion de ressources métier)
- Respecter une architecture claire (controller/service/repository)
- Ajouter des tests unitaires
- Produire une documentation exploitable (README + backlog)

## Équipe

- Nom Prénom - rôle (PO / Lead Dev / Dev / QA)
- Nom Prénom - rôle
- Nom Prénom - rôle

## Stack

- Java 17/21
- Gradle (wrapper)
- JUnit 5
- (à venir) Spring Boot, DB, Docker

## Installation

### Prérequis

- Java 17/21
- Git

### Cloner

\`\`\`bash
git clone <URL>
cd <repo>
\`\`\`

## Lancer

### Tests

\`\`\`bash
./gradlew test
\`\`\`

### Run (si application Gradle)

\`\`\`bash
./gradlew run
\`\`\`

## Workflow Git

- **main** : stable
- **develop** : intégration
- **feature/*** : 1 user story = 1 branche
- PR obligatoire vers develop

TP4.2 – Rapport de synthèse
Repositories créés

UserRepository : gestion des utilisateurs, recherche par email pour futur JWT

ProjectRepository : accès aux projets, filtrage par owner

TaskRepository : gestion des tâches, query methods pour filtrer par status et projectId

Query methods ajoutées

List<Task> findByStatus(TaskStatus status)

List<Task> findByProjectId(Long projectId)

Optional<User> findByEmail(String email)

CRUD standard héritées de JpaRepository

Services migrés

TaskService : suppression des mocks, utilisation des repositories JPA

Gestion correcte des cas “introuvable” via Optional.orElseThrow

Stratégie de seed

CommandLineRunner insère un utilisateur et un projet de test si la base est vide

Tâches de test liées à ce projet pour cohérence des relations

Problèmes rencontrés

Driver MySQL absent -> ajouté mysql-connector-java:8.0.33

Méthodes setX non trouvées -> ajouté Lombok (@Getter, @Setter, @NoArgsConstructor, @AllArgsConstructor)

Validation @Valid et contraintes @NotBlank, @Size, @Pattern -> dépendances Jakarta Validation

Lazy loading et sérialisation JSON -> utilisé DTOs pour les réponses API

À améliorer avant séance 5

Ajouter JWT pour authentification

Gérer les rôles (admin / user) dans les endpoints

Compléter les DTOs pour Project et User

Ajouter tests unitaires pour services et controllers

## Backlog

Voir `BACKLOG.md`.

## Documentation

- [Domain Model](docs/DOMAIN_MODEL.md)
- [Package Structure](docs/PACKAGE_STRUCTURE.md)
