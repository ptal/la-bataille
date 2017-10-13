Bataille! by *Timothé PARDIEU*
===================
descriptions

> Descriptions
> Le jeu de la bataille est un jeu de cartes.
> Il est composé de 52 cartes et de deux joueurs.
> Chaque joueur reçoit ainsi 26 cartes.



----------

But du jeu
-------------
Le but du jeu est de tirer la dernière carte de son deck et de confronter la valeur de la carte à celle de l'adversaire.
La plus grosse valeur l'emporte et le gagnant récupère les cartes mises en jeu.
En cas d'égalité il y'a "**bataille**" . 

*Les cas possibles de l'égalité :*

 - Le joueur n'a plus de carte après ce tour
 - Il reste une carte au joueur
 - Le joueur a encore au moins deux cartes

Si le joueur dispose d'assez de cartes il met en jeu la carte qui a provoqué l'égalité, il tire une autre carte qui est aussi misé puis il tire une troisième carte qui sera décisive en étant comparé à la troisième carte de l'adversaire . Sinon on vérifie laquelle des cartes est la plus "forte"


----------
#### <i class="icon-file"></i> Mode de jeu "basiques" 
**Mode Joueur VS Joueur **
Dans ce mode (disponible au choix 1) [ :one: ]  ) le jeu vous demandera de saisir un nom pour chaque joueur. 
La partie ne se termine que quand l'utilisateur le souhaite en appuyant sur la touche 2 du menu principal .
Chaque joueur peut poser sa carte en appuyant sur "**Entrer**"

**Mode Joueur VS Ordinateur **
Ce mode est accessible depuis le choix numéro 2) [ :two: ].
Ce mode est rigoureusement pareil que précèdent mais permet de jouer a un joueur contre un "ordinateur".

----------

#### <i class="icon-pencil"></i> Ajout de mode au jeu 

**Mode statistiques**

Dans ce mode (disponible depuis le 3) du menu du jeu), l'utilisateur peut entrer le nombre de parties qu'il veut exécuter.
Celles-ci se déroulent entre deux "ordinateurs". 
Une fois toutes les parties de jeu exécutées l'utilisateur peut revoir en détails les détails des parties. Il peut également voir les "batailles" mais aussi connaître le pourcentage de victoire pour chaque "ordinateur".

---
> **NB:**
> - La javadoc peut être générée
> - Le code est basé sur l'anglais donc les commentaires et les variables sont dans cette langue
> - L'aspect du code se réfère à : [hyc.io](http://www.hyc.io/teaching/java/evaluation-code.pdf) 

-----

> **Ressources:**
Les règles du jeu ont été renseigné par :
> - http://www.momes.net/Jeux/Jeux-et-animations/Regles-des-jeux-de-cartes/La-bataille-regles-du-jeu
> - Wikipédia

-----
** README DE BASE **
# la-bataille
Jeu de carte "la bataille" dans le cadre du cours Java/UPMC

Instructions
============

Le jeu se compile avec la commande `mvn compile`.

Vous pouvez lancer une partie avec `mvn exec:java -Dexec.mainClass="upmc.game.Bataille"`

TP 1
====

* Le début de l'énoncé du TP se trouve à la fin du cours 1
* En plus, on vous demande de proposer un mode interactif dans lequel :
  1. Le système indique quelle joueur doit jouer.
  2. L'utilisateur peut décider de tirer une carte (simplement en appuyant sur "enter").
* Proposer un menu à 2 entrées : (1) Tirer la prochaine carte (2) Quitter.
* Permettez aux deux joueurs d'entrer leurs noms.
* Proposer un mode où un joueur peut jouer contre un ordinateur.
* Rendre le projet le plus ergonomique et soigné possible.
* Étendez les règles à votre sauce pour rendre le tout plus intéressant.
* Faites un rapport d'une page maximum pour expliquer les nouvelles règles implémentées.
* Veuillez à respecter la grille d'évaluation.

La date de rendu est sur le [site du cours](http://hyc.io/teaching/java.html).

TP 2
====

* Lire le code de l'interface `LecturePseudo` fournie.
Elle indique que les classes qui implémenteront cette interface permettent de lire le pseudo d'un joueur.
* Implémenter cette interface avec les classes `LectureConsole` et `LectureFichier`.
Elles permettent de lire respectivement les pseudos d'un fichier et de la console.
* La classe `LectureConsole` demandera de l'utilisateur le nom d'un fichier à lire.
Dans ce fichier, il y aura les pseudos utilisateurs à raison d'un par ligne.
* Ensuite vous ajoutez une classe `MenuPseudo` qui propose une méthode `public LecturePseudo modeLecturePseudo()`.
Elle propose un menu dans lequel l'utilisateur peut choisir de quelles manières il veut lire les pseudos: via un fichier ou via la console.
La méthode renvoie la classe correspondante (i.e. `LectureConsole` ou `LectureFichier`): vu qu'elles implémentent toutes deux `LecturePseudo`, on peut juste les manipuler via `LecturePseudo`.
Un exemple:
```
LecturePseudo lecturePseudo = menu.modeLecturePseudo();
ArrayList<String> pseudos = lecturePseudo.lirePseudo();
...
```
On peut utiliser `lirePseudo` sur `LecturePseudo` de manière générique.

* Utiliser `MenuPseudo` dans votre méthode `main` principale.

La date de rendu est sur le [site du cours](http://hyc.io/teaching/java.html).

Info
====

Synchroniser un fork avec son répertoire courant:

```
git remote add upstream https://github.com/ptal/la-bataille.git
git fetch upstream
git checkout master
git merge upstream/master
```
Source: [synchroniser un fork](https://help.github.com/articles/syncing-a-fork/)

