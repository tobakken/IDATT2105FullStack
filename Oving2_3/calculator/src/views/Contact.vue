<template>
  <form @submit.prevent="submit">
    <div>
      <BaseInput
          v-model="name"
          label="Name"
          type="name"
          :error="errors.name"/>
    </div>

    <div>
      <BaseInput
          v-model="email"
          label="Email"
          type="email"
          :error="errors.email"
      />
    </div>

    <BaseInput
        v-model="message"
        label="Message"
        type="textarea"
        :error ="errors.message"
    />

    <button type="submit"
            :disabled="errors.name || errors.email || errors.message"
    >Submit</button>
  </form>

  <div class="submit-msg"
       v-if="submitting"
  >Sending
  </div>
  <div class="submit-msg"
       v-if="submitMessage"
  >Your message has been sent!
  </div>
</template>

<script>
import BaseInput from "../components/BaseInput";
import { useForm, useField } from "vee-validate";
import { object, string } from "yup";
import { ref } from "vue";
import { useStore } from 'vuex';

export default {
  name: "Contact",
  components: { BaseInput },
  setup() {
    const validationSchema = object({
      name: string().required(),
      email: string().required().email(),
      message: string().required()
    })

    const { handleSubmit, errors } = useForm({
      validationSchema,
      initialValues: {
        name: "",
        email: "",
        message: ""
      }
    })

    const {value: name} = useField('name')
    const {value: email} = useField('email')
    const {value: message} = useField('message')

    const store = useStore();
    name.value = store.state.name
    email.value = store.state.email

    const submitting = ref(false)
    const submitMessage = ref(false)

    const submit = handleSubmit(values => {
      store.commit("SET_NAME", name)
      store.commit("SET_EMAIL", email)
      console.log("submit", values);
      submitting.value = true;
      setTimeout(() =>{
        submitting.value = false;
        submitMessage.value = true;
      }, 1500);

    })

    return {
      message,
      name,
      email,
      submit,
      submitting,
      submitMessage,
      errors
    }
  }

}
</script>

<style>
.submit-msg {
  font-weight: bold;
}

.field {
  margin-bottom: 24px;
}

input,
text{
  font-family: "Open sans", sans-serif;
  font-size: 100%;
  line-height: 1.15;
  margin: 10px;
  margin-bottom: 20px;
}
.error {
  border: 1px solid red;
}
.errorMessage {
  color: red;
  font-size: 15px;
}

input + p.errorMessage {
  margin-bottom: 24px;
}

input.error{
  margin-bottom: 0;
}



</style>