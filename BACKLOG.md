<<<<<<< HEAD
\# Backlog - Projet SI Java



\## MVP



\- \[ ] US-01 Init repo + Gradle + structure

\- \[ ] US-02 Auth: register

\- \[ ] US-03 Auth: login

\- \[ ] US-04 Ressource métier 1: CRUD

\- \[ ] US-05 Ressource métier 2: CRUD (liée à ressource 1)

\- \[ ] US-06 Filtre / recherche simple



\## Bonus



\- \[ ] Swagger / OpenAPI

\- \[ ] Pagination + tri
=======
\# Backlog Produit - Projet SI Java (ESIEE‑IT)



\## Acteurs



\- \*\*Visiteur\*\* : non connecté

\- \*\*Utilisateur\*\* : connecté

\- \*\*Admin\*\* : supervision / gestion (bonus)



\## Modules / Features



\- \*\*A. Authentification \& Profil\*\*

\- \*\*B. Gestion des projets\*\*

\- \*\*C. Gestion des tâches\*\*

\- \*\*D. Recherche / Filtre\*\*

\- \*\*E. Administration\*\* (bonus)



---



\## User Stories (MoSCoW + estimation)



| ID | Module | User Story | Priorité | Estim (S/M/L) |

|----|--------|------------|----------|---------------|

| US-01 | Auth | En tant que Visiteur, je veux créer un compte afin de pouvoir accéder à l’application. | Must | M |

| US-02 | Auth | En tant que Utilisateur, je veux me connecter afin de retrouver mes projets. | Must | M |

| US-03 | Auth | En tant que Utilisateur, je veux me déconnecter afin de sécuriser ma session. | Should | S |

| US-04 | Auth | En tant que Utilisateur, je veux modifier mon profil afin de mettre à jour mes informations. | Should | M |

| US-05 | Gestion projets | En tant que Utilisateur, je veux créer un projet afin de structurer mon travail. | Must | M |

| US-06 | Gestion projets | En tant que Utilisateur, je veux lister mes projets afin de voir tout ce que je gère. | Must | S |

| US-07 | Gestion projets | En tant que Utilisateur, je veux modifier un projet afin de corriger ou compléter ses infos. | Must | M |

| US-08 | Gestion projets | En tant que Utilisateur, je veux supprimer un projet afin de nettoyer ma liste. | Should | M |

| US-09 | Gestion tâches | En tant que Utilisateur, je veux ajouter une tâche dans un projet afin de planifier les actions à faire. | Must | M |

| US-10 | Gestion tâches | En tant que Utilisateur, je veux changer le statut d’une tâche afin de suivre l’avancement. | Must | S |

| US-11 | Gestion tâches | En tant que Utilisateur, je veux modifier une tâche afin d’ajuster son contenu. | Should | S |

| US-12 | Gestion tâches | En tant que Utilisateur, je veux supprimer une tâche afin d’enlever les tâches inutiles. | Should | S |

| US-13 | Recherche / Filtre | En tant que Utilisateur, je veux filtrer les tâches par statut afin de me concentrer sur les tâches urgentes. | Nice | S |

| US-14 | Recherche / Filtre | En tant que Utilisateur, je veux rechercher une tâche par mot-clé afin de retrouver rapidement une information. | Nice | S |

| US-15 | Administration | En tant qu’Admin, je veux lister tous les utilisateurs afin de surveiller la plateforme. | Nice | M |



---



\## Critères d’acceptation (BDD)



\### US-01 - Inscription

\*\*Scénario 1 : Inscription réussie\*\*  

\- Given je suis visiteur  

\- When je fournis email valide + mot de passe conforme  

\- Then un compte est créé  

\- And je peux me connecter  



\*\*Scénario 2 : Email déjà utilisé\*\*  

\- Given un compte existe avec mon email  

\- When je tente de m’inscrire avec le même email  

\- Then un message d’erreur “Email déjà utilisé” apparaît  



\*\*Scénario 3 : Mot de passe trop court\*\*  

\- Given je suis sur la page d’inscription  

\- When je saisis un mot de passe < 8 caractères  

\- Then un message d’erreur “Mot de passe trop court” apparaît  



---



\### US-02 - Login

\*\*Scénario 1 : Connexion réussie\*\*  

\- Given mon compte existe  

\- When je saisis email et mot de passe corrects  

\- Then je suis connecté et redirigé vers le dashboard  



\*\*Scénario 2 : Email ou mot de passe incorrect\*\*  

\- Given mon compte existe  

\- When je saisis un mot de passe incorrect  

\- Then un message d’erreur apparaît et je reste sur la page login  



---



\### US-03 - Logout

\- Given je suis connecté  

\- When je clique sur “Déconnexion”  

\- Then ma session est fermée et je suis redirigé vers la page login  



---



\### US-04 - Modifier profil

\- Given je suis connecté  

\- When je modifie nom/email et je sauvegarde  

\- Then les informations sont mises à jour  

\- And un message de confirmation apparaît  



---



\### US-05 - Créer projet

\*\*Scénario 1 : Création réussie\*\*  

\- Given je suis connecté  

\- When je crée un projet avec un titre valide  

\- Then le projet apparaît dans ma liste  



\*\*Scénario 2 : Titre vide\*\*  

\- Given je suis connecté  

\- When je crée un projet sans titre  

\- Then un message d’erreur apparaît et le projet n’est pas créé  



---



\### US-06 - Lister projets

\- Given je suis connecté  

\- When j’ouvre la page projets  

\- Then tous mes projets sont affichés avec titre et date de création  



---



\### US-07 - Modifier projet

\- Given un projet existe  

\- When je modifie son titre ou description  

\- Then les changements sont enregistrés et visibles  



---



\### US-08 - Supprimer projet

\- Given un projet existe  

\- When je le supprime  

\- Then il n’apparaît plus dans la liste  

\- And un message de confirmation apparaît  



---



\### US-09 - Ajouter tâche

\*\*Scénario 1 : Tâche ajoutée\*\*  

\- Given je suis connecté sur un projet existant  

\- When je crée une tâche avec un titre valide  

\- Then la tâche apparaît dans la liste du projet  



\*\*Scénario 2 : Titre vide\*\*  

\- Given je suis connecté  

\- When je crée une tâche sans titre  

\- Then un message d’erreur apparaît et la tâche n’est pas créée  



---



\### US-10 - Changer statut tâche

\- Given une tâche existe  

\- When je modifie son statut (ex: “En cours” → “Terminé”)  

\- Then le statut est mis à jour et visible dans la liste  



---



\### US-11 - Modifier tâche

\- Given une tâche existe  

\- When je change titre/description  

\- Then les modifications sont enregistrées et visibles  



---



\### US-12 - Supprimer tâche

\- Given une tâche existe  

\- When je la supprime  

\- Then elle n’apparaît plus dans le projet  

\- And un message de confirmation apparaît  



---



\### US-13 - Filtrer tâches

\- Given plusieurs tâches avec différents statuts  

\- When je filtre par statut “En cours”  

\- Then seules les tâches “En cours” sont affichées  



---



\### US-14 - Rechercher tâche

\- Given plusieurs tâches avec différents titres/descriptions  

\- When je recherche un mot-clé existant  

\- Then seules les tâches correspondantes sont affichées  



---



\### US-15 - Lister utilisateurs (Admin)

\- Given je suis Admin  

\- When j’accède à la page utilisateurs  

\- Then tous les comptes sont listés avec statut actif/bloqué  

\- And je peux filtrer ou chercher un utilisateur  


>>>>>>> main

\- \[ ] Docker Compose

\- \[ ] CI build + tests

