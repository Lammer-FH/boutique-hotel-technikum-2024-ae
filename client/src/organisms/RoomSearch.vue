<template>
  <div>
    <div class="inline pb-10">
      <DatePicker v-model="startDate" pickerId="start-date-picker" />
      <div class="centered">bis</div>
      <DatePicker v-model="endDate" pickerId="end-date-picker" />
    </div>
    <MainButton identifier="search" @search="search" />
    <FeedbackMessage
      :isOpen="isAlertOpen"
      message="End date cannot be before start date"
      @close-alert="isAlertOpen = false"
    />
  </div>
</template>

<script>
import { MainButton } from "@/atoms";
import { DatePicker } from "@/molecules";
import { useRoomStore } from "@/store";
import FeedbackMessage from "@/atoms/FeedbackMessage.vue";

export default {
  name: "RoomSearch",
  components: {
    DatePicker,
    MainButton,
    FeedbackMessage,
  },
  data() {
    return {
      startDate: new Date().toISOString(),
      endDate: new Date().toISOString(),
      isAlertOpen: false,
      roomStore: useRoomStore(),
    };
  },
  methods: {
    search() {
      if (this.startDate && this.endDate) {
        if (new Date(this.endDate) < new Date(this.startDate)) {
          this.isAlertOpen = true;
        } else {
          this.roomStore.fetchRooms(this.startDate, this.endDate);
        }
      } else {
        this.roomStore.fetchRooms();
      }
    },
  },
};
</script>

<style scoped>
.inline {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}
.pt-10 {
  padding-top: 10px;
}
.pb-10 {
  padding-bottom: 10px;
}
.centered {
  align-self: center;
}
</style>
