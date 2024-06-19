<template>
  <div class="inline pb-10">
    <DatePicker v-model="roomStore.startDate" pickerId="start-date-picker-2" />
    <div class="centered">bis</div>
    <DatePicker v-model="roomStore.endDate" pickerId="end-date-picker-2" />
    <MainButton
      identifier="checkAvailability"
      @checkAvailability="checkAvailability"
      text="Verfügbarkeit prüfen"
      icon="mdi:shield-check-outline"
      :disabled="roomStore.loading"
    />
    <FeedbackMessage
      :isOpen="isDateAlertOpen"
      message="Startdatum kann nicht nach Enddatum liegen!"
      @close-alert="isDateAlertOpen = false"
    />
    <FeedbackMessage
      :isOpen="roomStore.isAvailabilityAlertOpen"
      message="Zimmer konnte zu den angegebenen Daten nicht gefunden werden"
      @close-alert="closeAvailabilityAlert"
    />
  </div>
</template>

<script>
import { MainButton } from "@/atoms";
import { DatePicker } from "@/molecules";
import { useRoomStore } from "@/store";
import { FeedbackMessage } from "@/atoms";

export default {
  name: "RoomAvailability",
  components: {
    DatePicker,
    MainButton,
    FeedbackMessage,
  },
  data() {
    return {
      isDateAlertOpen: false,
      roomStore: useRoomStore(),
    };
  },
  methods: {
    checkAvailability() {
      if (this.roomStore.startDate > this.roomStore.endDate) {
        this.isDateAlertOpen = true;
        return;
      }
      this.roomStore.fetchRoom();
    },
    closeAvailabilityAlert() {
      this.roomStore.isAvailabilityAlertOpen = false;
    },
  },
};
</script>

<style scoped>
.inline {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
}
.pb-10 {
  padding-bottom: 10px;
}
</style>
