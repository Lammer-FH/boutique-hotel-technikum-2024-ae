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