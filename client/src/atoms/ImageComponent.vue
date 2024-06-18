<template>
  <div class="image">
    <img alt="Bild des Zimmers" :src="imageUrl" class="image" />
  </div>
</template>

<script>
import { useImageStore } from "@/store";

export default {
  name: "ImageComponent",
  props: {
    filename: {
      type: String,
      required: true,
    },
  },
  data: () => ({
    imageStore: useImageStore(),
    imageUrl: "",
  }),
  async mounted() {
    this.imageUrl = await this.imageStore.fetchImage(this.filename);
  },
};
</script>

<style scoped>
.image {
  width: 100%;
  max-height: 250px;
  object-fit: cover;
}

@media (min-width: 768px) {
  .image {
    max-height: 1000px;
  }
}
</style>
