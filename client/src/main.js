import router from "./router";
import { createApp } from "vue";
import App from "./App.vue";
import { createPinia } from "pinia";
import { IonicVue } from "@ionic/vue";
import "@ionic/vue/css/core.css";
import "@ionic/vue/css/ionic.bundle.css";

const app = createApp(App);

app.use(router);
app.use(IonicVue);
app.use(createPinia());

app.mount("#app");
