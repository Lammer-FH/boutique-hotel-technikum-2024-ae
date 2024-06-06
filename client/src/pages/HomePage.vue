<template>
  <ion-page>
    <ion-content>
        <ion-img src="https://docs-demo.ionic.io/assets/madison.jpg"/>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonContent, IonImg } from '@ionic/vue';

export default {
  name: 'HomePage',
  components: {
    IonPage,
    IonContent,
    IonImg,
  },
};
</script>

<style scoped>
</style>
