<template>
  <ion-card>
    <ion-card-content>
      <ion-text><b>Bestellformular</b></ion-text>
      <ion-input label="Vorname" type="text" model:firstname/>
      <ion-input label="Nachname" type="text" model:lastname/>
      <ion-input label="E-Mail Adresse" type="email" model:mailaddress/>
      <ion-select label="Frühstück" model:breakfast>
        <ion-select-option>Ja</ion-select-option>
        <ion-select-option>Nein</ion-select-option>
      </ion-select>
      <ion-button @click="order">Bestellen</ion-button>
    </ion-card-content>
  </ion-card>
</template>

<script>

import {useRoomStore} from "@/store";
import {useOrderStore} from "@/store/useOrderStore";

export default {
  name: "OrderForm",
  data: () => ({
    roomStore: useRoomStore(),
    orderStore: useOrderStore(),
    firstname: "",
    lastname: "",
    mailaddress: "",
    breakfast: "Ja",
    hasOrdered: false,
  }),
  methods: {
    order() {
      this.orderStore.addOrder(
          this.roomStore.startDate,
          this.roomStore.endDate,
          this.roomStore.currentRoom,
          this.firstname,
          this.lastname,
          this.mailaddress,
          this.breakfast === "Ja"
      )
      if (this.orderStore.hasOrdered)
      {
        this.hasOrdered = true;
      }
    }
  }
}
</script>

<style scoped>

</style>