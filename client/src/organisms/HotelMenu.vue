<template>
    <ion-menu side="end" content-id="main-content">
    <ion-header>
        <ion-toolbar>
        <ion-title></ion-title>
        </ion-toolbar>
    </ion-header>
    <ion-content class="ion-padding">
        <ion-list>
        <ion-menu-toggle>
            <ion-button>
            <ion-icon slot="start" :icon="bedOutline" ></ion-icon>
            Zimmer buchen
            </ion-button>
        </ion-menu-toggle>
        <ion-menu-toggle>
            <ion-button router-link="/kontakt">
            <ion-icon slot="start" :icon="personCircleOutline"></ion-icon>
            Kontakt
            </ion-button>
        </ion-menu-toggle>
        </ion-list>
    </ion-content>
    </ion-menu>
</template>
  
<script>
import {  IonMenu, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonList, IonIcon,  IonMenuToggle } from '@ionic/vue';

export default {
name: 'HotelMenu',
components: {
    IonMenu, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonList, IonIcon, IonMenuToggle
},
};
</script>