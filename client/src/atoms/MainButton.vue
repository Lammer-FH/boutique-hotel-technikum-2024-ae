<template>
  <ion-button
    expand="block"
    fill="outline"
    size="small"
    @click="onClick"
    :disabled="disabled"
  >
    <Icon :icon="icon" class="font-15" />
    {{ text }}
  </ion-button>
</template>

<script>
import { Icon } from "@iconify/vue";
import { IonButton } from "@ionic/vue";

export default {
  name: "MainButton",
  components: {
    IonButton,
    Icon,
  },
  props: {
    identifier: String,
    disabled: Boolean,
    text: String,
    icon: String,
  },
  methods: {
    onClick() {
      this.$emit(this.identifier);
    },
  },
};
</script>

<style scoped>
.font-15 {
  font-size: 15pt;
}
</style>
