\# Architecture Decisions



\## Décision 1

Les identifiants utilisent le type Long pour être compatibles avec JPA.



\## Décision 2

Les statuts de tâches utilisent une enum TaskStatus.



\## Décision 3

Les rôles utilisateurs utilisent une enum UserRole.



\## Décision 4

Les dates utilisent Instant pour garder un timestamp précis.



\## Décision 5

Les relations ManyToMany sont évitées pour simplifier le modèle initial.



