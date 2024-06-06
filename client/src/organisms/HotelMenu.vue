<template>
  <ion-menu side="end" content-id="main-content">
    <ion-header>
      <ion-toolbar>
        <ion-title>Menü</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content class="ion-padding">
      <ion-list>
        <div>
          <MenuButton :icon="bedOutline" title="Zimmer buchen" />
          <MenuButton
            :icon="personCircleOutline"
            title="Kontakt"
            link="/contact"
          />
        </div>
      </ion-list>
    </ion-content>
  </ion-menu>
</template>

<script>
import {
  IonMenu,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonList,
} from "@ionic/vue";
import { MenuButton } from "@/atoms";
import { bedOutline, personCircleOutline } from "ionicons/icons";

export default {
  name: "HotelMenu",
  components: {
    IonMenu,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonList,
    MenuButton,
  },
  setup() {
    return { bedOutline, personCircleOutline };
  },
};
</script>
