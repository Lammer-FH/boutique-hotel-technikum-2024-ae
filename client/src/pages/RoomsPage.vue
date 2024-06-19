<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <RoomSearch />
      </ion-toolbar>
    </ion-header>
    <ion-content>
      <div class="container pt-10 page">
        <RoomList />
      </div>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonContent, IonHeader, IonToolbar } from "@ionic/vue";
import { RoomSearch, RoomList } from "@/organisms";

export default {
  name: "RoomsPage",
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
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
