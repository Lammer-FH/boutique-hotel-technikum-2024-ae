<template>
  <ion-page>
    <ion-content>
      <div class="container">Buchungsbestätigung</div>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonContent, IonPage } from "@ionic/vue";
import { useBookingStore } from "@/store";

export default {
  name: "BookingConfirmationPage",
  components: {
    IonPage,
    IonContent,
  },
  data: () => ({
    bookingStore: useBookingStore(),
  }),
};
</script>
