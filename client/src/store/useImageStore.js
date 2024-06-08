import { defineStore } from "pinia";
import axios from "axios";

// error: process is not defined??
// const apiUrl = process.env.VUE_APP_API_URL;

const apiUrl = "http://localhost:8081/api/v1";

export const useImageStore = defineStore("image", {
  state: () => ({}),
  getters: {},
  actions: {
    async fetchImage(filename) {
      let imageUrl = "ImageNotFound.jpg";
      await axios
        .get(apiUrl + "/images", {
          params: {
            filename: filename,
          },
          responseType: "blob",
        })
        .then((response) => {
          imageUrl = window.URL.createObjectURL(
            new Blob([response.data], { type: "image/jpg" })
          );
        })
        .catch((error) => {
          console.log(error);
        })
        .then();

      return imageUrl;
    },
  },
});
