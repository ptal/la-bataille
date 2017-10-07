# la-bataille
Jeu de carte "la bataille" dans le cadre du cours Java/UPMC

Instructions
============

Le jeu se compile avec la commande `mvn compile`.

Vous pouvez lancer une partie avec `mvn exec:java -Dexec.mainClass="upmc.game.Bataille"`


Règles du jeu
=============
Chaque joueur se voit attribuer un tas de carte (représenté par un tableau). 
* Le premier joueur va choisir de jouer seul ou contre un ordinateur
* A chaque tour le (ou les) joueurs vont devoir choisir entre tirer une carte ou quitter le jeu (l'ordinateur choisi d'office de tirer une carte)
* La personne qui a la carte la plus grosse remporte le point
* En cas d'égalité de valeur (soit bataille), les cartes sont remises en jeu
* Le premier joueur à avoir 100 points remporte la partie
* Si la partie est arrêté avant la fin c'est le joueur avec le plus de carte qui remporte la partie
* La plus petite carte est le 1 et la plus grosse est le roi / Le jeu et composé de 52 cartes.

Explication des différentes classes
===================================

**Classe Bataille**
* Classe Principale du jeu : elle contient toutes les initialisation des autres classes et elle défini le déroulement du jeu

**Classe Carte**
* Classe qui initialise une carte pour l'afficher et qui la compare à une autre carte

**Classe InitPlayers**
* Classe qui initialise le nombre de joueurs (1 ou 2) et le nom de chaques joueurs

**Classe Joueur**
* Classe qui est spécifique affiche les informations propre au joueur tel que son score
* Classe qui permet de tirer une carte, en enlever ou en rajouter