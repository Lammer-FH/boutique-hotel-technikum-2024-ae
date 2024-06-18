<template>
  <div class="p-10">
    <div class="inline">
      <FilterButton identifier="filter" />
      <DatePicker
        v-model="roomStore.startDate"
        pickerId="start-date-picker"
        :disabled="!roomStore.isFiltering"
      />
      <div class="centered">bis</div>
      <DatePicker
        v-model="roomStore.endDate"
        pickerId="end-date-picker"
        :disabled="!roomStore.isFiltering"
      />
      <MainButton
        identifier="search"
        @search="search"
        text="Suchen"
        :disabled="!roomStore.isFiltering || roomStore.loading"
        icon="mdi:magnify"
      />
    </div>
    <FeedbackMessage
      :isOpen="isAlertOpen"
      message="Startdatum kann nicht nach Enddatum liegen!"
      @close-alert="isAlertOpen = false"
    />
  </div>
</template>

<script>
import { MainButton, FilterButton } from "@/atoms";
import { DatePicker } from "@/molecules";
import { useRoomStore } from "@/store";
import FeedbackMessage from "@/atoms/FeedbackMessage.vue";

export default {
  name: "RoomSearch",
  components: {
    DatePicker,
    MainButton,
    FilterButton,
    FeedbackMessage,
  },
  data() {
    return {
      isAlertOpen: false,
      roomStore: useRoomStore(),
    };
  },
  methods: {
    search() {
      if (this.roomStore.startDate > this.roomStore.endDate) {
        this.isAlertOpen = true;
        return;
      }
      this.roomStore.fetchRooms(true);
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
.pt-10 {
  padding-top: 10px;
}
.p-10 {
  padding: 10px;
}
.centered {
  align-self: center;
}
</style>
