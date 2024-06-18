import { defineStore } from "pinia";
import axios from "axios";
import { formatDate } from "@/utils/dateUtils";
import router from "../router";

// error: process is not defined??
// const apiUrl = process.env.VUE_APP_API_URL;

const apiUrl = "http://localhost:8081/api/v1";

export const useBookingStore = defineStore("booking", {
  state: () => ({
    firstname: "",
    lastname: "",
    mail: "",
    breakfast: true,
    currentBooking: null,
  }),
  getters: {},
  actions: {
    addBooking(startDate, endDate, roomId) {
      const guest = {
        firstName: this.firstname,
        lastName: this.lastname,
        email: this.mail,
      };

      const params = {
        roomId: roomId,
        startDate: formatDate(startDate),
        endDate: formatDate(endDate),
        guest: guest,
        breakfast: this.breakfast,
      };

      axios
        .post(apiUrl + "/bookings", params)
        .then((response) => {
          this.currentBooking = response.data;
          router.push("/bookingConfirmation");
        })
        .catch((error) => {
          console.log(error);
        })
        .then(() => {});
    },
  },
});
