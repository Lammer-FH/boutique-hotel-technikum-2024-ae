<template>
  <ion-card @click="navigate" class="w-100">
    <ImageComponent :filename="anchorImageFilename" />
    <ion-card-header>
      <ion-card-title>{{ room.name }}</ion-card-title>
    </ion-card-header>

    <ion-card-content>
      <div class="truncate">
        {{ room.description }}
      </div>
      <CharacteristicsTable :characteristics="room.characteristics" />
    </ion-card-content>
  </ion-card>
</template>

<script>
import {
  IonCard,
  IonCardHeader,
  IonCardTitle,
  IonCardContent,
} from "@ionic/vue";
import { useRoomStore } from "@/store";
import { ImageComponent } from "@/atoms";
import { CharacteristicsTable } from "@/molecules";

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
    IonCardContent,
    ImageComponent,
    CharacteristicsTable,
  },
  methods: {
    navigate() {
      this.roomStore.setCurrentRoom(this.room);
      this.$router.push("/roomDetails");
    },
  },
  computed: {
    anchorImageFilename() {
      const filename = this.room.images.find((image) => image.anchor)?.filename;
      return filename ?? "NoImage.jpg";
    },
  },
};
</script>

<style scoped>
.w-100 {
  width: 100%;
}

.truncate {
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  overflow: hidden;
}
</style>
