<template>
  <div>
    <ion-datetime-button :datetime="pickerId" @click="isOpen = true"></ion-datetime-button>

    <ion-modal :keep-contents-mounted="true" :is-open="isOpen" @didDismiss="onDidDismiss">
      <ion-datetime
        :id="pickerId"
        presentation="date"
        :min="min"
        :max="max"
        v-model="selectedDate"
        @ionChange="handleDateChange"
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
  props: {
    modelValue: {
      type: String,
      required: true,
    },
    pickerId: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      selectedDate: this.modelValue,
      isOpen: false,
    };
  },
  watch: {
    modelValue(newValue) {
      this.selectedDate = newValue;
    },
    selectedDate(newValue) {
      this.$emit("update:modelValue", newValue);
    },
  },
  computed: {
    min() {
      return new Date().toISOString();
    },
    max() {
      const d = new Date();
      const year = d.getFullYear();
      const month = d.getMonth();
      const day = d.getDate();
      return new Date(year + 5, month, day).toISOString();
    },
  },
  methods: {
    onDidDismiss() {
      this.isOpen = false;
    },
    handleDateChange(event) {
      this.selectedDate = event.detail.value;
      this.isOpen = false;
    },
  },
};
</script>
