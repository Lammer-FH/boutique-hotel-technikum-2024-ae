<template>
  <ion-page>
    <ion-content>
      <ion-text>{{formatDate(roomStore.startDate)}} bis {{formatDate(roomStore.endDate)}}</ion-text>
      <RoomCard :room="roomStore.currentRoom"/>
      <OrderForm/>
    </ion-content>
  </ion-page>
</template>

<script>
import {IonContent, IonPage} from "@ionic/vue";
import {useRoomStore} from "@/store";
import {RoomCard} from "@/molecules";
import OrderForm from "@/molecules/OrderForm.vue";
import {formatDate} from "../utils/dateUtils";

export default {
  name: "RoomDetailsPage",
  methods: {formatDate},
  components: {
    OrderForm,
    RoomCard,
    IonPage,
    IonContent,
  },
  data: () => ({
    roomStore: useRoomStore(),
  }),
};
</script>
