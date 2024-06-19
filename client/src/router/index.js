import { createRouter, createWebHistory } from "@ionic/vue-router";
import {
  HomePage,
  ImprintPage,
  DataProtectionPage,
  ContactPage,
  TermsAndConditionsPage,
  RoomsPage,
  RoomDetailsPage,
  BookingConfirmationPage,
} from "@/pages";

const routes = [
  {
    path: "/",
    name: "Hotel Technikum",
    component: HomePage,
  },
  {
    path: "/imprint",
    name: "Impressum",
    component: ImprintPage,
  },
  {
    path: "/data-protection",
    name: "Datenschutz",
    component: DataProtectionPage,
  },
  {
    path: "/contact",
    name: "Kontakt",
    component: ContactPage,
  },
  {
    path: "/terms-and-conditions",
    name: "AGB",
    component: TermsAndConditionsPage,
  },
  {
    path: "/rooms",
    name: "Zimmer",
    component: RoomsPage,
  },
  {
    path: "/roomDetails",
    name: "Details",
    component: RoomDetailsPage,
  },
  {
    path: "/bookingConfirmation",
    name: "Buchungsbestätigung",
    component: BookingConfirmationPage,
  },
];

const router = createRouter({
  // eslint-disable-next-line no-undef
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
