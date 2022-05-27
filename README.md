# Simulateur d'une Machine à café en Java - Version final testé.

Ce dossier est la version final du travail.
Comme le montre la vidéo YT (Le mode d'emploi), lors de l'appuie sur le bouton **Bas** 
on voit les informations après combien de tasses faut-il faire la maintenance ou l'entretient.<br/>

**Entretient :**<br/>
Remplissage reservoir d'eau dans --> 2 Tasses<br/>
Vidange du bac colecteur dans    --> 3 Tasses<br/>
Remplissage reservoir d'eau dans --> 4 Tasses<br/>
<br/>
**Maintenance :** <br/>
Nettoyage dans   --> 2 Tasses<br/>
Détartrage dans  --> 3 Tasses<br/>
calc'nClean dans --> 6 Tasses
<br/><br/>


## Contributeurs

Projet réalisé à l'UMONS, année académique 2020-2021
dans le cadre du cours de Modélisation Logicielle
Master en Sciences Informatiques
à horaire décalé à Charleroi

**Auteurs**: Mohsine DANI, Youness KAZZOUL

**Enseignants du cours**: Tom MENS, Gauvain DEVILLEZ


## Documentation

Lien vidéo contenant le mode d’emploi, démontrant les fonctionnalités de l’application :
https://www.youtube.com/watch?v=_PW220TLZ8w


## Informations

**I. Phase Modélisation :**
- Les diagrammes : des uses cases, de classes, de séquences, Overview et d'activité sont réalisé dans Visual Paradigme.
- Statchart réalisé sur YAKINDU


**II. Phase Implémentation :**
- Projet développé avec Java Swing.
- SDK 1.8 java version 1.11.0-openjdk-amd64
- Test Unitaire junit 5
- Gradle: org.junit.jupiter:junit-jupiter-api:5.6.2


## Instructions d'installation

**Pour exécuter l'application:**
1. Dans intellij on utiliser la commande suivante dans le terminal :<br/>
gradle clean build run<br/>

2. Pour une utilisation externe sans rien installer, uniquement telecharger le zip, par exemple sur Linux on se place dans le répertoire parent "com.danikazzoul", et on lance la commande suivante :<br/>
java -jar build/libs/com.daniKazzoul-1.0-SNAPSHOT.jar<br/><br/>


**P.S.1** : Si un problème persiste, il faut installer **GCC**



