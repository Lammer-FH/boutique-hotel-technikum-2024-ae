<template>
  <ion-page>
    <ion-content>
      <ion-card>
        <ion-card-content>
          <div class="container"><b>Buchungsnummer: {{ bookingStore.currentBooking.bookingNumber }}</b></div>
          <ion-item v-for="room in this.bookingStore.currentBooking.rooms" :key="room" role="article">
            <RoomCard :room="room"/>
          </ion-item>
          <BookingFormInput
              label="Vorname"
              placeholder="Max"
              type="text"
              v-model="bookingStore.currentBooking.guests[0].firstName"
              errorText="Der Vorname darf nicht länger als 50 Zeichen sein!"
              :disabled="true"
          />
          <BookingFormInput
              label="Nachname"
              placeholder="Mustermann"
              type="text"
              v-model="bookingStore.currentBooking.guests[0].lastName"
              errorText="Der Nachname darf nicht länger als 50 Zeichen sein!"
              :disabled="true"
          />
          <BookingFormInput
              label="Email"
              placeholder="max.mustermann@mail.com"
              type="email"
              v-model="bookingStore.currentBooking.guests[0].email"
              errorText="Die Email muss gütlig und darf nicht länger als 50 Zeichen sein!"
              :disabled="true"
          />
          <ToggleComponent
              label="Frühstück"
              :checked="bookingStore.currentBooking.breakfast"
              @updateToggle="onUpdateBreakfast"
              :disabled="true"
          />
        </ion-card-content>
      </ion-card>
    </ion-content>
  </ion-page>
</template>

<script>
import {IonContent, IonItem, IonPage} from "@ionic/vue";
import {useBookingStore} from "@/store";
import {RoomCard} from "@/molecules";
import {BookingFormInput, ToggleComponent} from "@/atoms";

export default {
  name: "BookingConfirmationPage",
  components: {
    ToggleComponent, BookingFormInput,
    RoomCard, IonItem,
    IonPage,
    IonContent,
  },
  data: () => ({
    bookingStore: useBookingStore(),
  }),
};
</script>
