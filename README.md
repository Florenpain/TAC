# TAC

Ce dépôt contient le projet à réaliser pour l'UE [TAC](https://www.fil.univ-lille.fr/portail/index.php?dipl=MInfo&sem=ES&ue=TAC&label=Pr%C3%A9sentation) de l'Université de Lille.

*[Lien du sujet](https://github.com/Florenpain/TAC/blob/main/CahierDesCharges.pdf)*

*[Documentation Android](https://developer.android.com/guide/index.html)*

*[Documentation Technique](https://github.com/Florenpain/TAC/blob/main/documentationTechnique.pdf)*

# Auteur 

*[Florentin BUGNON](https://github.com/Florenpain)*

# Travail réalisé 

- Récupération de la liste de champions du jeu 'League of Legends' depuis une API : *[Data Dragon](https://developer.riotgames.com/docs/lol) (cf section 'Data Dragon')*
- Affichage de la liste des champions dans un onglet 'Champions'
- L'affichage se fait en liste ou en grille, et peut être modifié en appuyant sur un bouton 'Switch' présent en haut à droite de l'écran
- En cliquant sur un champion, on ouvre une nouvelle page contenant des informations supplémentaires sur le champion ( un appel API est réalisé pour récupérer les informations du champion sélectionné)
- Chaque section représentant un champion contient au minimum (dépend de l'affichage en liste ou en grille):
  - un bouton qui permet d'ajouter le champion à une liste de favoris
  - une image du champion
  - le nom du champion
- L'onglet 'Favoris' permet d'afficher la liste des champions ajoutés en favoris
- Ces champions favoris sont stockés en local

# Diagrammes

Ces diagrammes ont été réalisés sur [diagrams.net](https://www.diagrams.net/).

Pour les visualiser, il faudra ainsi les ouvrir sur ce site.

*[Diagramme de séquence](https://github.com/Florenpain/TAC/blob/main/DiagrammeS%C3%A9quence.drawio)*

*[Diagramme de classes](https://github.com/Florenpain/TAC/blob/main/DiagrammeClasses.drawio)*

# Planification 

| Travail à réaliser                              | Nom         | Etat               | Commentaire                                                                                                                                                                                              |
|-------------------------------------------------|-------------|--------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Affichage des items en liste                    | @florenpain | :white_check_mark: |                                                                                                                                                                                                          |
| Affichage des items en grille                   | @florenpain | :white_check_mark: |                                                                                                                                                                                                          |
| Transition de liste à grille et inversement     | @florenpain | :white_check_mark: |                                                                                                                                                                                                          |
| Affichage des détails d'un item (texte + image) | @florenpain | :white_check_mark: |                                                                                                                                                                                                          |
| Bouton d'actions (ajout/suppression en favori)  | @florenpain | :white_check_mark: | L'ajout / la suppression n'est pas dynamique : Il faut changer le format d'affichage en appuyant sur le bouton switch en haut à droite de l'écran pour mettre à jour les données de l'onglet 'favoris'   |
| Stockage des données en local                   | @florenpain | :white_check_mark: |                                                                                                                                                                                                          |
| Appel API Riot pour récupérer les données       | @florenpain | :white_check_mark: |                                                                                                                                                                                                          |
| Onglet d'items favoris                          | @florenpain | :white_check_mark: |                                                                                                                                                                                                          |


