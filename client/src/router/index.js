import { createRouter, createWebHistory } from '@ionic/vue-router';
import HomePage from '../pages/HomePage.vue';
import ImpressumPage from "../pages/ImpressumPage.vue"
import AboutPage from "../pages/AboutPage.vue"

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomePage,
  },
  {
    path: '/impressum',
    name: 'Impressum',
    component: ImpressumPage,
  },
  {
    path: '/about',
    name: 'About',
    component: AboutPage,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;