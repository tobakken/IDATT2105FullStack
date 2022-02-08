<template>
  <form @submit.prevent="onSubmit">
    <BaseInput
        v-model="name"
        label="Name"
        type="name"
        :error="nameError"/>

    <BaseInput
        v-model="email"
        label="Email"
        type="email"
        :error="emailError"
    />

    <BaseInput
        label="Message"
        type="textarea"
    />

    <button type="submit" @click="submit()">Submit</button>
  </form>

  <div class="submit-msg"
       v-if="submitMessage"
  >{{ submitMessage }}
  </div>
</template>

<script>
import BaseInput from "../components/BaseInput";
import {useForm, useField} from 'vee-validate';
import NProgress from 'nprogress';

export default {
  name: "Contact",
  components: {BaseInput},
  data() {
    return {
      submitMessage: ""
    }
  },
  methods: {
    submit() {
      NProgress.start();
      this.submitMessage = "Sending Message"
      setTimeout(() =>{
        NProgress.done()
        this.submitMessage = "Message sent";
      }, 3000);
    }
  },

  setup() {
    function onSubmit() {
    }

    const validations = {
      name: value => {
        if (!value) return 'This field is required'
        return true
      },
      email: value => {
        if (!value) return 'This field is required'
        return true
      }
    }
    useForm({
      validationSchema: validations
    })

    const {value: name, errorMessage: nameError} = useField('name')
    const {value: email, errorMessage: emailError} = useField('email')

    return {
      onSubmit,
      name,
      nameError,
      email,
      emailError
    }
  }

}
</script>

<style scoped>
.submit-msg {
  font-weight: bold;
}



</style>