<template>
  <div class="w-100">
    <ion-textarea
      :label="label"
      :placeholder="placeholder"
      label-placement="floating"
      auto-grow="true"
      v-model="message"
      inputmode="text"
    ></ion-textarea>
    <span class="pt-10 pb-10 position-right">
      <ion-button fill="clear" @click="sendMessage">
        <ion-icon slot="end" :icon="send" size="small"></ion-icon>
      </ion-button>
    </span>
  </div>
</template>

<script>
import { IonIcon, IonTextarea, IonButton } from "@ionic/vue";
import { send } from "ionicons/icons";

export default {
  name: "MessageArea",
  components: {
    IonIcon,
    IonTextarea,
    IonButton,
  },
  setup() {
    return { send };
  },
  data: () => ({
    message: "",
  }),
  props: {
    label: String,
    placeholder: String,
  },
  methods: {
    sendMessage() {
      if (this.message.length > 0) {
        this.$emit("send-message", this.message);
        this.message = "";
      }
    },
  },
};
</script>

<style scoped>
.w-100 {
  width: 100%;
}
.pt-10 {
  padding-top: 10px;
}
.pb-10 {
  padding-bottom: 10px;
}
.position-right {
  display: flex;
  justify-content: end;
}
</style>
