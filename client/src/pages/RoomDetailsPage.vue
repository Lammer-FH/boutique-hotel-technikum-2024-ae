<template>
  <ion-page>
    <ion-content>
      <div class="container">
        <h2>{{ roomStore.currentRoom.name }}</h2>
        {{ roomStore.currentRoom.description }}
        <CharacteristicsTable
          :characteristics="roomStore.currentRoom.characteristics"
        />
        <ion-card
          v-for="image in roomStore.currentRoom.images"
          :key="image.imageId"
        >
          <ImageComponent :filename="image.filename" />
        </ion-card>
        <RoomAvailability />
        <BookingForm :disabled="bookingDisabled" />
      </div>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonCard, IonContent, IonPage } from "@ionic/vue";
import { useBookingStore, useRoomStore } from "@/store";
import { formatDate } from "../utils/dateUtils";
import BookingForm from "@/molecules/BookingForm.vue";
import { ImageComponent } from "@/atoms";
import { CharacteristicsTable } from "@/molecules";
import { RoomAvailability } from "@/organisms";

export default {
  name: "RoomDetailsPage",
  methods: { formatDate },
  components: {
    IonPage,
    IonContent,
    IonCard,
    BookingForm,
    ImageComponent,
    CharacteristicsTable,
    RoomAvailability,
  },
  data: () => ({
    roomStore: useRoomStore(),
    bookingStore: useBookingStore(),
  }),
  computed: {
    bookingDisabled() {
      return (
        (!this.roomStore.isFiltering &&
          this.roomStore.availableRoomId !==
            this.roomStore.currentRoom.roomId) ||
        (this.bookingStore.currentBooking &&
          this.bookingStore.currentBooking.rooms[0].roomId ===
            this.roomStore.currentRoom.roomId)
      );
    },
  },
};
</script>
