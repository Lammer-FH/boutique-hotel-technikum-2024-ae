<template>
  <ion-card @click="navigate">
    <img
      alt="Silhouette of mountains"
      src="https://ionicframework.com/docs/img/demos/card-media.png"
    />
    <ion-card-header>
      <ion-card-title>{{ room.name }}</ion-card-title>
      <ion-card-subtitle>Card Subtitle</ion-card-subtitle>
    </ion-card-header>

    <ion-card-content>
      {{ room.description }}
    </ion-card-content>
  </ion-card>
</template>

<script>
import {
  IonCard,
  IonCardHeader,
  IonCardTitle,
  IonCardSubtitle,
  IonCardContent,
} from "@ionic/vue";
import { useRoomStore } from "@/store";

export default {
  name: "RoomCard",
  data: () => ({
    roomStore: useRoomStore(),
  }),
  props: {
    room: {
      type: Object,
      required: true,
    },
  },
  components: {
    IonCard,
    IonCardHeader,
    IonCardTitle,
    IonCardSubtitle,
    IonCardContent,
  },
  methods: {
    navigate() {
      this.roomStore.setCurrentRoom(this.room);
      this.$router.push("/roomDetails");
    },
  },
};
</script>
