<template>
    <ion-alert
      :is-open="isOpen"
      :message="message"
      :buttons="['OK']"
      @didDismiss="closeAlert"
    ></ion-alert>
  </template>
  
  <script>
  import { IonAlert } from "@ionic/vue";
  
  export default {
    name: "FeedbackMessage",
    components: {
      IonAlert,
    },
    props: {
      isOpen: {
        type: Boolean,
        required: true,
      },
      message: {
        type: String,
        required: true,
      },
    },
    methods: {
      closeAlert() {
        this.$emit("close-alert");
      },
    },
  };
  </script>
  
  <style scoped></style>
  