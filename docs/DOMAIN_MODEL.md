\# DOMAIN\_MODEL.md



\# 1. Acteurs



\## User

Utilisateur authentifié :

\- Crée et gère ses projets

\- Ajoute et modifie des tâches

\- Commente les tâches

\- Assigne des tâches



\## Admin

Administrateur :

\- Gère les utilisateurs

\- Modère projets et tâches

\- Peut effectuer toutes les actions



\## System (optionnel)

\- Notifications automatiques

\- Logs / audit



---



\# 2. Cas d’usage (MVP)



UC-01 : En tant que User, je veux créer un projet afin d’organiser mon travail.  

UC-02 : En tant que User, je veux lister mes projets afin de les consulter.  

UC-03 : En tant que User, je veux ajouter une tâche à un projet afin de planifier une action.  

UC-04 : En tant que User, je veux changer le statut d’une tâche afin de suivre son avancement.  

UC-05 : En tant que User, je veux ajouter un commentaire à une tâche afin de collaborer.  

UC-06 : En tant que User, je veux assigner une tâche à un utilisateur.  

UC-07 : En tant que User, je veux archiver une tâche.  

UC-08 : En tant que Admin, je veux gérer les utilisateurs.



---



\# 3. Entités métier



\## User

\- id : Long

\- email : String (unique)

\- username : String (unique)

\- passwordHash : String

\- role : UserRole

\- createdAt : Instant



\## Project

\- id : Long

\- name : String

\- description : String

\- owner : User

\- createdAt : Instant

\- updatedAt : Instant



\## Task

\- id : Long

\- title : String

\- description : String

\- status : TaskStatus

\- priority : TaskPriority

\- project : Project

\- assignee : User (optionnel)

\- dueDate : LocalDate (optionnel)

\- createdAt : Instant

\- updatedAt : Instant



\## Comment

\- id : Long

\- content : String

\- task : Task

\- author : User

\- createdAt : Instant



---



\# 4. Enums



\## TaskStatus

\- TODO

\- IN\_PROGRESS

\- DONE

\- ARCHIVED



\## TaskPriority

\- LOW

\- MEDIUM

\- HIGH



\## UserRole

\- USER

\- ADMIN



---



\# 5. Relations



\- User 1..N Project

\- Project 1..N Task

\- Task 1..N Comment

\- User 1..N Comment

\- User 1..N Task (assignee)



---



\# 6. Règles métier (Invariants)



\## User

\- email obligatoire et unique

\- username obligatoire et unique

\- passwordHash obligatoire

\- un utilisateur a exactement un rôle



\## Project

\- name obligatoire (1 à 80 caractères)

\- un projet a exactement un owner



\## Task

\- title obligatoire (1 à 120 caractères)

\- status obligatoire

\- une tâche appartient à un projet

\- dueDate ne peut pas être dans le passé (optionnel)



\## Comment

\- content obligatoire (1 à 500 caractères)

\- un commentaire a un auteur et appartient à une tâche



---



\# 7. Workflow TaskStatus



Transitions autorisées :



\- TODO → IN\_PROGRESS

\- IN\_PROGRESS → DONE

\- DONE → ARCHIVED

\- TODO → ARCHIVED (annulation)



Transitions interdites :



\- DONE → TODO

\- ARCHIVED → autre statut



ARCHIVED est un état final.



---



\# 8. Diagramme de classes (Mermaid)



```mermaid

classDiagram



class User {

&nbsp; Long id

&nbsp; String email

&nbsp; String username

&nbsp; String passwordHash

&nbsp; UserRole role

&nbsp; Instant createdAt

}



class Project {

&nbsp; Long id

&nbsp; String name

&nbsp; String description

&nbsp; Instant createdAt

&nbsp; Instant updatedAt

}



class Task {

&nbsp; Long id

&nbsp; String title

&nbsp; String description

&nbsp; TaskStatus status

&nbsp; TaskPriority priority

&nbsp; LocalDate dueDate

&nbsp; Instant createdAt

&nbsp; Instant updatedAt

}



class Comment {

&nbsp; Long id

&nbsp; String content

&nbsp; Instant createdAt

}



User "1" --> "N" Project : owns

Project "1" --> "N" Task : contains

Task "1" --> "N" Comment : has

User "1" --> "N" Comment : writes

User "1" --> "N" Task : assigned



