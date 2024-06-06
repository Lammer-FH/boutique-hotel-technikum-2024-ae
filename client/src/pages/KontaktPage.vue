<template>
  <ion-page>
    <ion-content>
      <div class="container">
        <h2><HotelName /></h2>
        <ion-list lines="full">
          <ion-item>
            <ion-icon slot="start" :icon="home" size="small"></ion-icon
            ><AddressComponent />
          </ion-item>
          <ion-item>
            <ion-icon slot="start" :icon="callOutline" size="small"></ion-icon
            ><PhoneComponent />
          </ion-item>
          <ion-item>
            <ion-icon slot="start" :icon="mailOutline" size="small"></ion-icon
            ><a href="mailto:office@hotel-technikum.com"><MailComponent /></a>
          </ion-item>
          <ion-item>
            <MessageArea
              label="Oder senden Sie uns direkt eine Nachricht:"
              placeholder="Was möchten Sie uns mitteilen?"
              @send-message="sendMessage"
            />
            <ToastComponent
              :isOpen="isToastOpen"
              message="Message sent successfully!"
              :duration="duration"
              @close-toast="closeToast"
            />
          </ion-item>
        </ion-list>
      </div>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonContent, IonIcon, IonItem, IonList } from "@ionic/vue";
import { mailOutline, callOutline, home } from "ionicons/icons";
import { ToastComponent } from "@/atoms/";
import { MessageArea } from "@/molecules";
import {
  PhoneComponent,
  AddressComponent,
  MailComponent,
  HotelName,
} from "@/assets";

export default {
  name: "KontaktPage",
  components: {
    IonPage,
    IonContent,
    IonIcon,
    IonItem,
    IonList,
    ToastComponent,
    MessageArea,
    PhoneComponent,
    AddressComponent,
    MailComponent,
    HotelName,
  },
  setup() {
    return { mailOutline, callOutline, home };
  },
  data: () => ({
    isToastOpen: false,
    duration: 5000,
  }),
  methods: {
    sendMessage(message) {
      // should send an email or something
      console.log(message);
      this.isToastOpen = true;
    },
    closeToast() {
      this.isToastOpen = false;
    },
  },
};
</script>

<style scoped></style>
