<template>
  <ion-input
    ref="input"
    :label="label"
    label-placement="stacked"
    :placeholder="placeholder"
    v-bind="model"
    :type="type"
    :error-text="errorText"
    :helper-text="helperText"
    @ionInput="validate"
    @ionBlur="markTouched"
    :disabled="disabled"
  ></ion-input>
</template>

<script>
import { IonInput } from "@ionic/vue";

export default {
  name: "BookingFormInput",
  data: () => ({}),
  props: {
    label: String,
    placeholder: String,
    model: String,
    type: String,
    errorText: String,
    helperText: String,
    disabled: Boolean,
  },
  components: {
    IonInput,
  },
  methods: {
    validate(ev) {
      const value = ev.target.value;

      this.$refs.input.$el.classList.remove("ion-valid");
      this.$refs.input.$el.classList.remove("ion-invalid");

      if (value === "") return;

      this.validateInput(value)
        ? this.$refs.input.$el.classList.add("ion-valid")
        : this.$refs.input.$el.classList.add("ion-invalid");
    },
    validateInput(value) {
      var valid = value.length <= 50;
      if (this.type === "email") {
        return (
          valid &&
          value.match(
            /^(?=.{1,254}$)(?=.{1,64}@)[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/
          )
        );
      }
      return valid;
    },
    markTouched() {
      this.$refs.input.$el.classList.add("ion-touched");
    },
  },
};
</script>

<style scoped></style>
