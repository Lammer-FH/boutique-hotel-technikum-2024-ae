<template>
  <div class="pt-10 resultContainer">
    <ion-list v-if="hasRooms" role="feed">
      <ion-item v-for="room in roomStore.rooms" :key="room" role="article">
        <RoomCard :room="room" />
      </ion-item>
    </ion-list>
    <div v-if="!hasRooms" class="noResultsLabel">
      <ion-icon
        :icon="closeCircleOutline"
        size="large"
        class="error"
      ></ion-icon>
      <ion-label class="error">Keine Ergebnisse gefunden</ion-label>
    </div>
    <ion-infinite-scroll @ionInfinite="onInfinite($event)">
      <ion-infinite-scroll-content loading-spinner="circular">
      </ion-infinite-scroll-content>
    </ion-infinite-scroll>
  </div>
</template>

<script>
import {
  IonList,
  IonLabel,
  IonItem,
  IonIcon,
  IonInfiniteScroll,
  IonInfiniteScrollContent,
} from "@ionic/vue";
import { RoomCard } from "@/molecules";
import { useRoomStore } from "@/store";
import { closeCircleOutline } from "ionicons/icons";

export default {
  name: "RoomList",
  data: () => ({
    roomStore: useRoomStore(),
  }),
  setup() {
    return { closeCircleOutline };
  },
  components: {
    IonList,
    IonLabel,
    IonItem,
    IonIcon,
    RoomCard,
    IonInfiniteScroll,
    IonInfiniteScrollContent,
  },
  computed: {
    hasRooms() {
      return this.roomStore.rooms.length > 0;
    },
  },
  mounted() {
    this.loadItems();
  },
  methods: {
    onInfinite(event) {
      this.loadItems();
      event.target.complete();
    },
    loadItems() {
      this.roomStore.fetchRooms();
    },
  },
};
</script>

<style scoped>
.pt-10 {
  padding-top: 10px;
}

.resultContainer {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  flex: 1;
}

.noResultsLabel {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.error {
  color: lightcoral;
}
</style>
