<template>
    <ion-page>
      <ion-header>
        <ion-toolbar>
          <ion-title>About</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-content>
        <h1>About Page</h1>
      </ion-content>
    </ion-page>
  </template>
  
  <script>
  import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent } from '@ionic/vue';
  
  export default {
    name: 'AboutPage',
    components: {
      IonPage,
      IonHeader,
      IonToolbar,
      IonTitle,
      IonContent,
    },
  };
  </script>
  
  <style scoped>
  </style>
  