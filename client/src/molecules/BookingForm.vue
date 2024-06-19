<template>
  <ion-card>
    <ion-card-content>
      <ion-text><b>Zimmer buchen</b></ion-text>
      <BookingFormInput
        label="Vorname"
        placeholder="Max"
        type="text"
        v-model="bookingStore.firstname"
        errorText="Der Vorname darf nicht länger als 50 Zeichen sein!"
        :disabled="disabled"
      />
      <BookingFormInput
        label="Nachname"
        placeholder="Mustermann"
        type="text"
        v-model="bookingStore.lastname"
        errorText="Der Nachname darf nicht länger als 50 Zeichen sein!"
        :disabled="disabled"
      />
      <BookingFormInput
        label="Email"
        placeholder="max.mustermann@mail.com"
        type="email"
        v-model="bookingStore.mail"
        errorText="Die Email muss gültig und darf nicht länger als 50 Zeichen sein!"
        :disabled="disabled"
      />
      <ToggleComponent
        label="Frühstück"
        :checked="bookingStore.breakfast"
        @updateToggle="onUpdateBreakfast"
        :disabled="disabled"
      />
      <MainButton
        identifier="book"
        @book="addBooking"
        text="Buchen"
        class="pt-10"
        icon="mdi:shield-check-outline"
        :disabled="disabled"
      />
    </ion-card-content>
  </ion-card>
</template>

<script>
import {useBookingStore, useRoomStore} from "@/store";
import {BookingFormInput, MainButton, ToggleComponent} from "@/atoms";
import {IonCard, IonCardContent, IonText} from "@ionic/vue";

export default {
  name: "BookingForm",
  data: () => ({
    roomStore: useRoomStore(),
    bookingStore: useBookingStore(),
  }),
  props: {
    disabled: {
      type: Boolean,
      default: false,
    },
  },
  components: {
    BookingFormInput,
    IonCard,
    IonCardContent,
    IonText,
    ToggleComponent,
    MainButton,
  },
  methods: {
    addBooking() {
      this.bookingStore.addBooking(
        this.roomStore.startDate,
        this.roomStore.endDate,
        this.roomStore.currentRoom.roomId
      );
    },
    onUpdateBreakfast(value) {
      this.bookingStore.breakfast = value;
    },
  },
};
</script>

<style scoped>
.pt-10 {
  padding-top: 10px;
}
</style>
