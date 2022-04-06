<template>
  <form @submit.prevent="submit">
    <div>
      <BaseInput v-model="username" label="Username" type="username" />
    </div>
    <BaseInput v-model="password" label="Password" type="password" />

    <button type="submit">Login</button>
  </form>
  <div v-if="validationSuccess">
    Login successful, taking you to the calculator
  </div>
  <div v-if="validationFailed">
    Login failed, please
    <router-link :to="{ name: 'Contact' }"> contact us</router-link>
  </div>
</template>

<script>
import BaseInput from "../components/BaseInput";
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import CalculatorService from "../services/CalculatorService"

export default {
  name: "Login",
  components: {
    BaseInput,
  },

  setup() {
    const username = ref("");
    const password = ref("");
    const router = useRouter();
    const validationSuccess = ref(false);
    const validationFailed = ref(false);
    const store = useStore();

    const submit = () => {
      CalculatorService.getToken(username.value, password.value).then((data) => {
        store.commit("SET_TOKEN", data.token);
        store.commit("SET_NAME", username.value);
        store.commit("SET_STATUS", "Validation success");
        validationSuccess.value = true;
        setTimeout(() => {
          router.push({ name: "Calculator" });
        }, 1500);      
      })
      .catch(() => {
        validationFailed.value = true;
        store.commit("SET_STATUS", "Validation failed");        
      })
    };

    return {
      username,
      password,
      submit,
      router,
      validationSuccess,
      validationFailed,
    };
  },
};
</script>
