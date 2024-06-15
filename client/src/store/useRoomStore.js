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
    startDate: null,
    endDate: null,
  }),
  getters: {},
  actions: {
    fetchRooms(startDate = this.startDate, endDate = this.endDate) {
      if (startDate && endDate && (startDate !== this.startDate || endDate !== this.endDate)) {
        this.offset = 0;
        this.rooms = [];
        this.startDate = startDate;
        this.endDate = endDate;
      }

      if (!this.loading && this.rooms.length < this.total) {
        this.loading = true;

        const params = {
          limit: this.limit,
          offset: this.offset,
        };

        if (this.startDate && this.endDate) {
          const formattedStartDate = formatDate(this.startDate);
          const formattedEndDate = formatDate(this.endDate);
          params.startDate = formattedStartDate;
          params.endDate = formattedEndDate;
        }

        axios
          .get(apiUrl + "/rooms", { params })
          .then((response) => {
            if (this.offset === 0) {
              this.rooms = response.data.roomDtos;
            } else {
              this.rooms.push(...response.data.roomDtos);
            }
            this.total = response.data.total;
            this.offset += this.limit;
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
