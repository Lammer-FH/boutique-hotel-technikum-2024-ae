<template>
  <ion-page>
    <ion-content>
      <div class="container pt-10 page">
        <RoomSearch />
        <RoomList />
      </div>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonContent } from "@ionic/vue";
import { RoomSearch, RoomList } from "@/organisms";

export default {
  name: "RoomsPage",
  components: {
    IonPage,
    IonContent,
    RoomSearch,
    RoomList,
  },
};
</script>

<style scoped>
.pt-10 {
  padding-top: 10px;
}
.page {
    display: flex;
    flex-direction: column;
    height: 100%;
}
</style>
