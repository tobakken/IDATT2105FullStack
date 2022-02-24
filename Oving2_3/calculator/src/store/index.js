import {createStore} from 'vuex'

export default createStore({
    state: {
        name:"",
        email: "",
        status: ""
    },
    mutations: {
        SET_NAME(state, name) {
            state.name = name
        },
        SET_EMAIL(state, email) {
            state.email = email
        },
        SET_STATUS(state, status) {
            state.status = status
        }
    }
})

