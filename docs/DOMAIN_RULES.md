\# DOMAIN RULES



\## 1. User



\### Validations

\- email : obligatoire, format email valide

\- username : obligatoire, entre 3 et 30 caractères

\- roles : obligatoire, au moins un rôle

\- passwordHash : optionnel (mais si présent, taille entre 10 et 255)



\### Règles métier

\- Un utilisateur doit avoir au moins un rôle

\- Un utilisateur peut avoir plusieurs rôles

\- Méthode : hasRole(UserRole)



\---



\## 2. Project



\### Validations

\- name : obligatoire, entre 1 et 80 caractères

\- description : optionnelle, max 500 caractères

\- owner : obligatoire



\### Règles métier

\- Un projet doit avoir un propriétaire

\- Le nom peut être modifié (rename)



\---



\## 3. Task



\### Validations

\- title : obligatoire, entre 1 et 120 caractères

\- description : optionnelle, max 1000 caractères

\- status : obligatoire (par défaut TODO)

\- project : obligatoire

\- assignee : optionnel



\### Workflow (transitions autorisées)



\- TODO → IN\_PROGRESS (start)

\- IN\_PROGRESS → DONE (complete)

\- DONE → ARCHIVED (archive)



\### Transitions interdites



\- TODO → DONE

\- TODO → ARCHIVED

\- IN\_PROGRESS → ARCHIVED (selon choix)



\### Règles métier

\- Une tâche appartient obligatoirement à un projet

\- Une tâche peut être assignée à un utilisateur

\- Une tâche peut être désassignée



\---



\## 4. Comment



\### Validations

\- content : obligatoire, entre 1 et 500 caractères

\- task : obligatoire

\- author : obligatoire



\### Règles métier

\- Un commentaire appartient à une tâche

\- Un commentaire a un auteur obligatoire



\---



\## 5. Exceptions



\- ValidationException : erreurs de validation (champs invalides)

\- BusinessRuleException : violation de règles métier (ex : transition interdite)

\- DomainException : exception de base



\---



\## 6. Décisions



\- Task.archive uniquement depuis DONE

\- passwordHash est optionnel pour ce TP

\- assignee est optionnel

\- description peut être null ou vide



