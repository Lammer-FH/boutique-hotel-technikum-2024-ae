import { defineStore } from "pinia";
import axios from "axios";
import { formatDate } from "@/utils/dateUtils";

// error: process is not defined??
// const apiUrl = process.env.VUE_APP_API_URL;

const apiUrl = "http://localhost:8081/api/v1";

export const useRoomStore = defineStore("room", {
  state: () => ({
    rooms: [],
    loading: false,
    limit: 5,
    offset: 0,
    total: 1, // to request at least once
    currentRoom: {},
  }),
  getters: {},
  actions: {
    fetchRooms() {
      if (!this.loading && this.rooms.length < this.total) {
        this.loading = true;
        axios
          .get(apiUrl + "/rooms", {
            params: {
              limit: this.limit,
              offset: this.offset,
            },
          })
          .then((response) => {
            this.rooms.push(...response.data.roomDtos);
            this.total = response.data.total;
            this.offset = response.data.offset + this.limit;
          })
          .catch((error) => {
            console.log(error);
          })
          .then(() => {
            this.loading = false;
          });
      }
    },
    setCurrentRoom(room) {
      this.currentRoom = room;
    },
    fetchAvailableRooms(startDate, endDate) {
      this.loading = true;
      const formattedStartDate = formatDate(startDate);
      const formattedEndDate = formatDate(endDate);
      axios
        .get(apiUrl + "/rooms/availability", {
          params: {
            startDate: formattedStartDate,
            endDate: formattedEndDate,
          },
        })
        .then((response) => {
          this.rooms = response.data.roomDtos;
          this.total = response.data.total;
          this.offset = this.limit;
        })
        .catch((error) => {
          console.log(error);
        })
        .then(() => {
          this.loading = false;
        });
    },
  },
});
