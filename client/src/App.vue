<template>
  <ion-app>
    <HotelMenu />
    <ion-page id="main-content">
      <ion-header>
        <ion-toolbar>
          <ion-title>{{ routeName }}</ion-title>
          <ion-buttons slot="end">
            <ion-menu-button></ion-menu-button>
          </ion-buttons>
        </ion-toolbar>
      </ion-header>
      <ion-content>
        <ion-router-outlet />
      </ion-content>
      <HotelFooter />
    </ion-page>
  </ion-app>
</template>

<script>
import {
  IonApp,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonPage,
  IonButtons,
  IonMenuButton,
  IonRouterOutlet,
} from "@ionic/vue";
import { bedOutline, personCircleOutline } from "ionicons/icons";
import { HotelMenu, HotelFooter } from "./organisms";

export default {
  name: "App",
  components: {
    IonApp,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonButtons,
    IonMenuButton,
    IonRouterOutlet,
    HotelMenu,
    HotelFooter,
  },
  setup() {
    return { bedOutline, personCircleOutline };
  },
  data() {
    return {
      routeName: null,
    };
  },

  watch: {
    $route: "currentRoute",
  },
  methods: {
    currentRoute() {
      this.$nextTick(() => {
        this.routeName = this.$route.name;
      });
    },
  },
};
</script>

<style>
.footer-menu {
  justify-content: space-around;
}
.footer-brand {
  justify-content: center;
}

/* used in other components but only defined once */
.container {
  padding-left: 10px;
  padding-right: 10px;
}
</style>
