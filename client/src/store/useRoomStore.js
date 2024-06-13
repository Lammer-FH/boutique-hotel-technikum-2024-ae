import { defineStore } from "pinia";
import axios from "axios";
import { formatDate } from "@/utils/dateUtils";

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
    fetchRooms(startDate, endDate) {
      // Reset offset and rooms if filtering by date
      if (startDate && endDate) {
        this.offset = 0;
        this.rooms = [];
      }

      if (!this.loading && this.rooms.length < this.total) {
        this.loading = true;

        const params = {
          limit: this.limit,
          offset: this.offset,
        };

        if (startDate && endDate) {
          const formattedStartDate = formatDate(startDate);
          const formattedEndDate = formatDate(endDate);
          params.startDate = formattedStartDate;
          params.endDate = formattedEndDate;
        }

        console.log("Fetching rooms with params:", params); // Debug log

        axios
          .get(apiUrl + "/rooms", { params })
          .then((response) => {
            console.log("Response from server:", response.data); // Debug log

            if (startDate && endDate) {
              this.rooms = response.data.roomDtos;
              this.total = response.data.total;
              this.offset = this.limit; // Reset offset for pagination
            } else {
              this.rooms.push(...response.data.roomDtos);
              this.total = response.data.total;
              this.offset += this.limit; // Update offset for pagination
            }
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
  },
});