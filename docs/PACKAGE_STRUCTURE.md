

```markdown

\# PACKAGE\_STRUCTURE.md



com.esiee.project

├── domain

│   ├── model

│   ├── enums

│   └── exception

├── application

│   ├── service

│   └── port

├── api

│   ├── controller

│   └── dto

└── infrastructure

&nbsp;   ├── persistence

&nbsp;   └── config



---



\# 2. Rôle des packages



\## domain

Contient les entités métier et les règles.

Aucune dépendance vers Spring ou la base de données.



\## application

Contient la logique des cas d’usage.

Orchestre les opérations métier.



\## api

Expose les endpoints REST.

Transforme DTO ↔ objets métier.



\## infrastructure

Contient la persistance (JPA), configuration et sécurité.



---



\# 3. Règles de dépendances



\- api → application

\- application → domain

\- infrastructure → application + domain

\- domain → dépend de personne



Le domain ne doit jamais dépendre de Spring ou JPA.

