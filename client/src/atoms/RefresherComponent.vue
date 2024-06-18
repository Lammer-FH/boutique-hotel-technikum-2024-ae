<template>
  <ion-refresher slot="fixed" @ionRefresh="handleRefresh($event)" class="front">
    <ion-refresher-content></ion-refresher-content>
  </ion-refresher>
</template>

<script>
import { IonRefresher, IonRefresherContent } from "@ionic/vue";

export default {
  name: "RefresherComponent",
  components: {
    IonRefresher,
    IonRefresherContent,
  },
  methods: {
    handleRefresh(event) {
      setTimeout(() => {
        this.$emit("refresh");
        event.target.complete();
      }, 2000);
    },
  },
};
</script>

<style>
.front {
  z-index: 100;
}
</style>
