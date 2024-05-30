<template>
  <ion-button>{{ text }}</ion-button>
</template>

<script>
import { defineComponent } from 'vue';
import { IonButton } from '@ionic/vue';

export default defineComponent({
  components: {
    IonButton
  },
  props: {
    text: {
      type: String,
      required: true
    }
  }
});
</script>