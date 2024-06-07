<template>
  <ion-page>
    <ion-content>
      <div>
        {{ roomStore.currentRoom.name }}
      </div>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonContent } from "@ionic/vue";
import { useRoomStore } from "@/store";

export default {
  name: "RoomDetailsPage",
  components: {
    IonPage,
    IonContent,
  },
  data: () => ({
    roomStore: useRoomStore(),
  }),
};
</script>
