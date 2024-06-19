<template>
  <ion-button
    expand="block"
    color="medium"
    fill="outline"
    size="small"
    @click="onClick"
  >
    <Icon v-if="roomStore.isFiltering" icon="mdi:filter" class="font-15" />
    <Icon v-if="!roomStore.isFiltering" icon="mdi:filter-off" class="font-15" />
  </ion-button>
</template>

<script>
import { Icon } from "@iconify/vue";
import { IonButton } from "@ionic/vue";
import { useRoomStore } from "@/store";

export default {
  name: "FilterButton",
  components: {
    IonButton,
    Icon,
  },
  data() {
    return {
      roomStore: useRoomStore(),
    };
  },
  methods: {
    onClick() {
      this.roomStore.toggleFilter();
    },
  },
};
</script>

<style scoped>
.font-15 {
  font-size: 15pt;
}
</style>
