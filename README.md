# LordsOfPlanets
CRUD web application on Spring Boot with filter. Used template - ThymeLeaf. Database - HSQLDB.

Lord - model from package LordsOfPlanets/src/main/java/lordsoftheplanets/ktochto/Model/, having parameters Id, Name, Age, Set of Planets,
describes requests and associates them with views LordController - controller for requests from package LordsOfPlanets/src/main/java/lordsoftheplanets/ktochto/Controller/, including requests:

GET html form
POST html form
Tasks

Submit a form for recording new data;
Uploading data to the server;
Update data;
Filter data by parameters Age and Planets.

Planet - model from package LordsOfPlanets/src/main/java/lordsoftheplanets/ktochto/Model/, having parameters Id, Name,
describes requests and associates them with views PlanetController - controller for requests from package LordsOfPlanets/src/main/java/lordsoftheplanets/ktochto/Controller/, including requests:

GET html form
POST html form
Tasks

Submit a form for recording new data;
Uploading data to the server;
Update data.

Project is created from the Maven archetype - webapp.
