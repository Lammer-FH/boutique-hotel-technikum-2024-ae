<template>
  <ion-footer>
    <ion-toolbar>
      <ion-buttons class="footer-menu">
        <ion-button router-link="/imprint">Impressum</ion-button>
        <ion-button router-link="/terms-and-conditions">AGB</ion-button>
        <ion-button router-link="/data-protection">Datenschutz</ion-button>
      </ion-buttons>
      <ion-buttons class="footer-brand">
        <ion-button router-link="/"><HotelName /></ion-button>
      </ion-buttons>
    </ion-toolbar>
  </ion-footer>
</template>

<script>
import { HotelName } from "@/assets";
import { IonToolbar, IonButtons, IonFooter, IonButton } from "@ionic/vue";

export default {
  name: "HotelFooter",
  components: {
    IonToolbar,
    IonButtons,
    IonFooter,
    IonButton,
    HotelName,
  },
};
</script>
