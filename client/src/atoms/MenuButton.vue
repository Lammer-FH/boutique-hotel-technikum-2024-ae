<template>
  <ion-menu-toggle>
    <ion-button fill="clear" :router-link="link" class="w-100">
      <ion-icon slot="start" :icon="icon"></ion-icon>
      {{ title }}
    </ion-button>
  </ion-menu-toggle>
</template>

<script>
import { IonButton, IonIcon, IonMenuToggle } from "@ionic/vue";

export default {
  name: "MenuButton",
  components: {
    IonButton,
    IonIcon,
    IonMenuToggle,
  },
  props: {
    icon: String,
    title: String,
    link: String,
  },
};
</script>

<style scoped>
.w-100 {
  width: 100%;
}
</style>
