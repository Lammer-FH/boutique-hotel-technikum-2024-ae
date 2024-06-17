import {defineStore} from "pinia";
import axios from "axios";
import {formatDate} from "@/utils/dateUtils";

const apiUrl = "http://localhost:8081/api/v1";

export const useOrderStore = defineStore("order", {
    state: () => ({
        hasOrdered: false,
        startDate: null,
        endDate: null,
        room: {},
        firstname: "",
        lastname: "",
        mailaddress: "",
        breakfast: false,
        currentOrder: null
    }),
    getters: {},
    actions: {
        addOrder(
            startDate = this.startDate,
            endDate = this.endDate,
            room = this.room,
            firstname = this.firstname,
            lastname = this.lastname,
            mailaddress = this.mailaddress,
            breakfast = this.breakfast
        ) {
            if (!this.hasOrdered) {
                this.hasOrdered = true;

                const params = {
                    "roomId": room.id,
                    "startDate": formatDate(startDate),
                    "endDate": formatDate(endDate),
                    "firstName": firstname,
                    "lastName": lastname,
                    "email": mailaddress,
                    "breakfast": breakfast
                };

                axios
                    .post(apiUrl + "/bookings", params)
                    .then((response) => {
                        this.currentOrder = response.data;
                    })
                    .catch((error) => {
                        console.log(error);
                    })
                    .then(() => {
                    });
            }
        },
    },
});
