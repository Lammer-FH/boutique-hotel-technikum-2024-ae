import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import { createPinia } from 'pinia';
import { IonicVue } from '@ionic/vue';
import '@ionic/vue/css/core.css';
import '@ionic/vue/css/ionic.bundle.css';

const app = createApp(App);

app.use(IonicVue);
app.use(router);
app.use(createPinia());

app.mount('#app');
