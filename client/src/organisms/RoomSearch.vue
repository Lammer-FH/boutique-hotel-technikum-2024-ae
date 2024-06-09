<template>
  <div>
    <div class="inline pb-10">
      <DatePicker />
      <div class="centered">bis</div>
      <DatePicker />
    </div>
    <MainButton identifier="search" @search="search" />
  </div>
</template>

<script>
import { MainButton } from "@/atoms";
import { DatePicker } from "@/molecules";

export default {
  name: "RoomSearch",
  components: {
    DatePicker,
    MainButton,
  },
  methods: {
    search() {
      // fetch rooms with date range
      console.log("search");
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
