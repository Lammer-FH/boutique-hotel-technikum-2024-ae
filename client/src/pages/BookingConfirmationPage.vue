<template>
  <ion-page>
    <ion-content>
      <ion-card>
        <ion-card-content>
          <ion-item v-for="room in this.bookingStore.currentBooking.rooms" :key="room" role="article">
            <RoomCard :room="room"/>
          </ion-item>
          <div class="container"><b>Buchungsnummer: {{ bookingStore.currentBooking.bookingNumber }}</b></div>
          <ion-item>Vorname: {{bookingStore.currentBooking.guests[0].firstName}}</ion-item>
          <ion-item>Nachname: {{bookingStore.currentBooking.guests[0].lastName}}</ion-item>
          <ion-item>Email: {{bookingStore.currentBooking.guests[0].email}}</ion-item>
          <ion-item>Frühstück: {{bookingStore.currentBooking.breakfast ? "Ja" : "Nein"}}</ion-item>
        </ion-card-content>
        <ion-card-content>
          <div class="container"><b>So erreichst du uns:</b></div>
          <div>
            <ion-item><h2><HotelName /></h2></ion-item>
            <ion-item>
              <AddressComponent />
            </ion-item>
            <ion-item>
              <PhoneComponent />
            </ion-item>
            <ion-item>
              <a href="mailto:office@hotel-technikum.com"><MailComponent /></a>
            </ion-item>
          </div>
          <div>
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2657.269324355657!2d16.374597976819672!3d48.23994274402854!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x476d064f6ed971cf%3A0x99fec738bbb12f9d!2sTechnikum%20Wien!5e0!3m2!1sde!2sat!4v1718778726633!5m2!1sde!2sat"
                    width="300"
                    height="250"
                    style="border:0;"
                    allowfullscreen=""
                    loading="lazy"
                    referrerpolicy="no-referrer-when-downgrade">
            </iframe>
          </div>
        </ion-card-content>
      </ion-card>
    </ion-content>
  </ion-page>
</template>

<script>
import {IonContent, IonItem, IonPage} from "@ionic/vue";
import {useBookingStore} from "@/store";
import {RoomCard} from "@/molecules";
import {AddressComponent, HotelName, MailComponent, PhoneComponent} from "@/assets";

export default {
  name: "BookingConfirmationPage",
  components: {
    MailComponent,
    PhoneComponent, AddressComponent,
    HotelName,
    RoomCard, IonItem,
    IonPage,
    IonContent,
  },
  data: () => ({
    bookingStore: useBookingStore(),
  }),
};
</script>
