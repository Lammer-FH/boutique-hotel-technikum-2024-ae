<template>
  <div id="app">
    <ion-app>
      <ion-router-outlet></ion-router-outlet>
      <ion-footer>
        <ion-toolbar>
          <ion-buttons>
            <ion-button :router-link="{ name: 'Home' }">Home</ion-button>
            <ion-button :router-link="{ name: 'Impressum' }">Impressum</ion-button>
            <ion-button :router-link="{ name: 'About' }">About</ion-button>
          </ion-buttons>
        </ion-toolbar>
      </ion-footer>
    </ion-app>
  </div>
</template>

<script>
import { IonApp, IonRouterOutlet, IonFooter, IonToolbar, IonButtons, IonButton } from '@ionic/vue';

export default {
  name: 'App',
  components: {
    IonApp,
    IonRouterOutlet,
    IonFooter,
    IonToolbar,
    IonButtons,
    IonButton,
  },
};
</script>

<style>
</style>
