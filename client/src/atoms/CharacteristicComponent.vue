<template>
  <div class="charachteristicContainer">
    <Icon :icon="characteristic.icon" class="font-15" />
    <span class="font-10">{{ characteristic.name }}</span>
  </div>
</template>

<script>
import { Icon } from "@iconify/vue";

export default {
  name: "CharacteristicComponent",
  data: () => ({}),
  props: {
    characteristic: {},
  },
  components: {
    Icon,
  },
};
</script>

<style scoped>
.font-10 {
  font-size: 10pt;
}
.font-15 {
  font-size: 15pt;
}
.charachteristicContainer {
  display: flex;
  flex-direction: row;
  align-items: end;
  gap: 5px;
}
</style>
