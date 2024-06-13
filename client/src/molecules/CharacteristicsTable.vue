<template>
  <ion-grid>
    <ion-row>
      <ion-col
        v-for="characteristic in characteristics"
        :key="characteristic.characteristicId"
      >
        <CharacteristicComponent :characteristic="characteristic" />
      </ion-col>
    </ion-row>
  </ion-grid>
</template>

<script>
import { IonCol, IonGrid, IonRow } from "@ionic/vue";
import { CharacteristicComponent } from "@/atoms";

export default {
  name: "CharacteristicsTable",
  components: {
    IonGrid,
    IonRow,
    IonCol,
    CharacteristicComponent,
  },
  data: () => ({}),
  props: {
    characteristics: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped></style>
