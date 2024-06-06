<template>
  <ion-page>
    <ion-content>
      <h2>Boutique-Hotel Technikum</h2> 
      <h2>Höchstädtplatz 6, 1200 Vienna, Austria</h2>
      <ion-toolbar>
        <ion-buttons slot = "start">
          <ion-button>
            <ion-icon slot="start" :icon="mailOutline" ></ion-icon>
            E-Mail
          </ion-button>
          <ion-button slot="end">
            <ion-icon slot="start" :icon="callOutline" ></ion-icon>
            Telefon
          </ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonContent, IonButtons, IonButton, IonIcon, IonToolbar } from '@ionic/vue';
import { mailOutline, callOutline } from 'ionicons/icons';

  
export default {
  name: 'KontaktPage',
  components: { 
    IonPage,
    IonContent,
    IonButtons, 
    IonButton,
    IonIcon,
    IonToolbar
  },
  setup() {
    return { mailOutline, callOutline}
  }
};
</script>

<style scoped>
</style>