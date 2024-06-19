<template>
  <ion-toggle
    class="item"
    v-model="value"
    :label="label"
    :checked="checked"
    @ionChange="handleChange"
    >{{ label }}</ion-toggle
  >
</template>

<script>
import { IonToggle } from "@ionic/vue";

export default {
  name: "ToggleComponent",
  components: {
    IonToggle,
  },
  props: {
    label: String,
    checked: Boolean,
  },
  data: () => ({
    value: false,
  }),
  methods: {
    handleChange() {
      this.$emit("updateToggle", this.value);
    },
  },
  mounted() {
    this.value = this.checked;
  },
};
</script>

<style scoped>
.item {
  display: flex;
  justify-content: space-between;
}
</style>
