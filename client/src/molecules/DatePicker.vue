<template>
  <div>
    <ion-datetime-button datetime="datetime"></ion-datetime-button>

    <ion-modal :keep-contents-mounted="true">
      <ion-datetime
        id="datetime"
        presentation="date"
        :min="min"
        :max="max"
      ></ion-datetime>
    </ion-modal>
  </div>
</template>

<script>
import { IonDatetimeButton, IonDatetime, IonModal } from "@ionic/vue";

export default {
  name: "DatePicker",
  components: {
    IonDatetimeButton,
    IonDatetime,
    IonModal,
  },
  computed: {
    min() {
      return new Date().toISOString();
    },
    max() {
      var d = new Date();
      var year = d.getFullYear();
      var month = d.getMonth();
      var day = d.getDate();
      return new Date(year + 5, month, day).toISOString();
    },
  },
};
</script>
