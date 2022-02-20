<template>
  <form @submit.prevent="submit">
    <div>
      <BaseInput
          v-model="username"
          label="Username"
          type="username"/>
    </div>
    <BaseInput
        v-model="password"
        label="Password"
        type="password"/>

    <button type="submit">Login</button>
  </form>
  <div v-if="validationSuccess">
    Login successful, taking you to the calculator
  </div>
  <div v-if="validationFailed">
    Login failed, please <router-link :to="{ name: 'Contact'}"> contact us</router-link>
  </div>
</template>

<script>


import BaseInput from "../components/BaseInput";
import {ref} from "vue";
import {useRouter} from "vue-router";

export default {
  name: 'Login',
  components: {
    BaseInput
  },

  setup () {

    const username = ref("")
    const password = ref("")
    const router = useRouter()
    const validationSuccess = ref(false)
    const validationFailed = ref(false)

    const submit = () => {
      if (username.value === "admin" && password.value === "admin"){
        validationSuccess.value = true
        setTimeout(() => {
          router.push( {name: "Calculator"} )
        }, 1500)
      } else {
        validationFailed.value = true
      }
    }

    return {
      username,
      password,
      submit,
      router,
      validationSuccess,
      validationFailed
    }
  }
}
</script>
