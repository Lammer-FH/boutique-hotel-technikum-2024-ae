import { createRouter, createWebHistory } from '@ionic/vue-router';
import HomePage from '../pages/HomePage.vue';
import ImpressumPage from "../pages/ImpressumPage.vue";
import DatenschutzPage from "../pages/DatenschutzPage.vue";
import KontaktPage from '../pages/KontaktPage.vue';
import AGBPage from '../pages/AGBPage.vue';

const routes = [
  {
    path: '/',
    name: 'Hotel Technikum',
    component: HomePage,
  },
  {
    path: '/impressum',
    name: 'Impressum',
    component: ImpressumPage,
  },
  {
    path: '/datenschutz',
    name: 'Datenschutz',
    component: DatenschutzPage,
  },
  {
    path: '/kontakt',
    name: 'Kontakt',
    component: KontaktPage,
  },
  {
    path: '/agb',
    name: 'AGB',
    component: AGBPage,
  }
];

const router = createRouter({
  // eslint-disable-next-line no-undef
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;