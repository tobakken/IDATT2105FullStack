import { createStore } from "vuex";

export default createStore({
  state: {
    token: "",
    username: "",
    email: "",
    status: "",
  },
  mutations: {
    SET_TOKEN(state, token) {
      state.token = token;
    },

    SET_NAME(state, username) {
      state.username = username;
    },
    SET_EMAIL(state, email) {
      state.email = email;
    },
    SET_STATUS(state, status) {
      state.status = status;
    },
  },
});
