<template>
  <ion-button expand="block" fill="outline" size="small" @click="onClick">
    <ion-icon slot="start" :icon="search"></ion-icon>
    Suchen
  </ion-button>
</template>

<script>
import { IonButton, IonIcon } from "@ionic/vue";
import { search } from "ionicons/icons";

export default {
  name: "MainButton",
  components: {
    IonButton,
    IonIcon,
  },
  props: {
    identifier: String,
  },
  setup() {
    return { search };
  },
  methods: {
    onClick() {
      this.$emit(this.identifier);
    },
  },
};
</script>
