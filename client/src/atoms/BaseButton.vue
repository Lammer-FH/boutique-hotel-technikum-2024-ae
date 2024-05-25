<template>
  <button class="btn">{{ text }}</button>
</template>

<script>
export default {
  name: 'BaseButton',
  props: {
    text: {
      type: String,
      required: true,
    },
  },
};
</script>

<style scoped>
.btn {
  background-color: #007bff;
  color: white;
  padding: 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>