<template>
  <ion-toast
    :is-open="isOpen"
    :message="message"
    :duration="duration"
    @didDismiss="closeToast()"
  ></ion-toast>
</template>

<script>
import { IonToast } from "@ionic/vue";

export default {
  name: "ToastComponent",
  components: {
    IonToast,
  },
  props: {
    isOpen: Boolean,
    message: String,
    duration: Number,
  },
  methods: {
    closeToast() {
      this.$emit("close-toast");
    },
  },
};
</script>
