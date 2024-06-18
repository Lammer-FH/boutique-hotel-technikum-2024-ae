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
    availableRoomId: 0, // id of available current room (to prevent available room without check on back and forth navigation)
    isAvailabilityAlertOpen: false,
    startDate: new Date().toISOString(),
    endDate: new Date(
      new Date().setDate(new Date().getDate() + 7)
    ).toISOString(),
    fetchedStartDate: null,
    fetchedEndDate: null,
    isFiltering: false,
  }),
  getters: {},
  actions: {
    fetchRooms(hardReload) {
      if (!this.loading) {
        // only fetch if not already fetching
        if (this.rooms.length >= this.total && !hardReload) {
          // if reached total and no hard reload forget fetching
          return;
        }

        this.loading = true;

        if (hardReload) {
          this.fetchedStartDate = this.startDate;
          this.fetchedEndDate = this.endDate;
        }

        const params = {
          limit: this.limit,
          offset: hardReload ? 0 : this.offset, // reset offset if hard reload
          startDate: this.isFiltering
            ? formatDate(this.fetchedStartDate)
            : null,
          endDate: this.isFiltering ? formatDate(this.fetchedEndDate) : null,
        };

        axios
          .get(apiUrl + "/rooms", { params })
          .then((response) => {
            if (hardReload) {
              this.rooms = response.data.roomDtos;
              this.offset = this.limit;
            } else {
              this.rooms.push(...response.data.roomDtos);
              this.offset += this.limit;
            }
            this.total = response.data.total;
          })
          .catch((error) => {
            console.log(error);
          })
          .then(() => {
            this.loading = false;
          });
      }
    },
    toggleFilter() {
      this.isFiltering = !this.isFiltering;
      this.fetchRooms(true);
    },
    setCurrentRoom(room) {
      this.currentRoom = room;
      this.availableRoomId = 0;
    },
    fetchRoom() {
      if (!this.loading) {
        this.loading = true;

        const params = {
          startDate: formatDate(this.startDate),
          endDate: formatDate(this.endDate),
        };
        console.log(this.currentRoom);

        axios
          .get(apiUrl + "/rooms/" + this.currentRoom.roomId, { params })
          .then((response) => {
            if (
              response.data &&
              response.data.roomId === this.currentRoom.roomId
            ) {
              this.availableRoomId = response.data.roomId;
            }
          })
          .catch((error) => {
            console.log(error);
            this.isAvailabilityAlertOpen = true;
          })
          .then(() => {
            this.loading = false;
          });
      }
    },
  },
});
