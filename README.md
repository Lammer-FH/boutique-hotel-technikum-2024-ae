# Boutique Hotel Technikum

> Verband: A, Gruppe E, Mitglieder: Foidl Lukas, Maier Niklas, Stefanovic Antonije, Stropp Stephan

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/bFlAvWr6)

## Setup

### Server

#### Initialize database

Execute following command in projects root directory:

```
docker-compose up
```

This should create a mysql docker conatiner and start it.

The script `Seeder.sql` provided in `server/sql` inserts test data into the database. An existing table structure is mandatory for execution. Common approach:

- start backend application
- query one endpoint (Spring initializes data structure automatically)
- execute sql script

### Client

Install dependencies in the `client/` directory:

```
npm install
```

## Execution

### Server

#### Start server

Until now the server needs to be started via an IDE. The easiest way is by starting IntelliJ, open the project `boutique-hotel-technikum` in the `server/` directory and run `BoutiqueHotelTechnikumApplication`. The server should then be up and running.

### Client

#### Compiles and hot-reloads for development

```
npm run serve
```

#### Compiles and minifies for production

```
npm run build
```

#### Lints and fixes files

```
npm run lint
```

## Additionals

### Icons

The used Icons are provided by <a href="https://ionic.io/ionicons">Ionic</a> Icons as well as <a href="https://icon-sets.iconify.design/mdi/">Iconify</a>