import {createStore} from 'vuex'

export default createStore({
    state: {
        name:"",
        email: "",
        status: ""
    }
})

//TODO: Add functionality for saving name,email and status to state.