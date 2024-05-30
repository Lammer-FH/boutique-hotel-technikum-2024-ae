<template>
    <ion-page>
      <ion-header>
        <ion-toolbar>
          <ion-title>Impressum</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-content>
        <h1>Impressum Page</h1>
      </ion-content>
    </ion-page>
  </template>
  
  <script>
  import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent } from '@ionic/vue';
  
  export default {
    name: 'ImpressumPage',
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