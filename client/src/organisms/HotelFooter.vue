<template>
    <ion-footer>
    <ion-toolbar>
        <ion-buttons class="footer-menu">
            <ion-button router-link="/impressum">Impressum</ion-button>
            <ion-button router-link="/agb">AGB</ion-button>
            <ion-button router-link="/datenschutz">Datenschutz</ion-button>
        </ion-buttons>
        <ion-buttons class="footer-brand">
            <ion-button router-link="/">Boutique-Hotel Technikum</ion-button>
        </ion-buttons>
    </ion-toolbar>
    </ion-footer>
</template>
  
<script>
import { IonToolbar, IonButtons, IonFooter, IonButton } from '@ionic/vue';

export default {
name: 'HotelFooter',
components: {
    IonToolbar, IonButtons, IonFooter, IonButton, 
},
};
</script>