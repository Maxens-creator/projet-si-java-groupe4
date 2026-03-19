\# API Errors Documentation



\## Format standard des erreurs



Toutes les erreurs de l’API suivent ce format JSON :



{

&#x20; "timestamp": "2026-03-19T10:00:00Z",

&#x20; "status": 400,

&#x20; "error": "VALIDATION\_ERROR",

&#x20; "message": "La requête est invalide",

&#x20; "path": "/api/tasks",

&#x20; "details": \[

&#x20;   {

&#x20;     "field": "title",

&#x20;     "message": "title est obligatoire"

&#x20;   }

&#x20; ]

}



\---



\## Liste des erreurs



\### 1. VALIDATION\_ERROR



\- Code HTTP : 400 Bad Request

\- Description : erreur de validation des données envoyées (DTO)



\#### Exemple



POST /api/tasks



Request invalide :

{

&#x20; "description": "Pas de titre"

}



Réponse :

{

&#x20; "timestamp": "2026-03-19T10:00:00Z",

&#x20; "status": 400,

&#x20; "error": "VALIDATION\_ERROR",

&#x20; "message": "La requête est invalide",

&#x20; "path": "/api/tasks",

&#x20; "details": \[

&#x20;   {

&#x20;     "field": "title",

&#x20;     "message": "title est obligatoire"

&#x20;   }

&#x20; ]

}



Endpoints concernés :

\- POST /api/tasks

\- PUT /api/tasks/{id}



\---



\### 2. NOT\_FOUND



\- Code HTTP : 404 Not Found

\- Description : ressource inexistante



\#### Exemple



GET /api/tasks/999



Réponse :

{

&#x20; "timestamp": "2026-03-19T10:00:00Z",

&#x20; "status": 404,

&#x20; "error": "NOT\_FOUND",

&#x20; "message": "Task introuvable: id=999",

&#x20; "path": "/api/tasks/999",

&#x20; "details": \[]

}



Endpoints concernés :

\- GET /api/tasks/{id}

\- PUT /api/tasks/{id}

\- DELETE /api/tasks/{id}



\---



\### 3. INVALID\_DATA



\- Code HTTP : 400 Bad Request

\- Description : données incohérentes mais valides techniquement



\#### Exemple



PUT /api/tasks/1



Réponse :

{

&#x20; "timestamp": "2026-03-19T10:00:00Z",

&#x20; "status": 400,

&#x20; "error": "INVALID\_DATA",

&#x20; "message": "Données invalides",

&#x20; "path": "/api/tasks/1",

&#x20; "details": \[]

}



Endpoints concernés :

\- PUT /api/tasks/{id}

\- POST /api/tasks



\---



\### 4. BUSINESS\_RULE\_VIOLATION



\- Code HTTP : 409 Conflict

\- Description : règle métier violée



\#### Exemple



PUT /api/tasks/1



Réponse :

{

&#x20; "timestamp": "2026-03-19T10:00:00Z",

&#x20; "status": 409,

&#x20; "error": "BUSINESS\_RULE\_VIOLATION",

&#x20; "message": "Transition de statut interdite",

&#x20; "path": "/api/tasks/1",

&#x20; "details": \[]

}



Endpoints concernés :

\- PUT /api/tasks/{id}



\---



\### 5. INTERNAL\_ERROR



\- Code HTTP : 500 Internal Server Error

\- Description : erreur inattendue côté serveur



\#### Exemple



{

&#x20; "timestamp": "2026-03-19T10:00:00Z",

&#x20; "status": 500,

&#x20; "error": "INTERNAL\_ERROR",

&#x20; "message": "Une erreur inattendue est survenue",

&#x20; "path": "/api/tasks",

&#x20; "details": \[]

}



Endpoints concernés :

\- Tous les endpoints



\---



\## Récapitulatif



| Code HTTP | Error                     | Description                      |

|----------|--------------------------|----------------------------------|

| 400      | VALIDATION\_ERROR         | Erreur validation DTO            |

| 400      | INVALID\_DATA             | Données incohérentes             |

| 404      | NOT\_FOUND                | Ressource introuvable            |

| 409      | BUSINESS\_RULE\_VIOLATION  | Règle métier violée              |

| 500      | INTERNAL\_ERROR           | Erreur serveur                   |



