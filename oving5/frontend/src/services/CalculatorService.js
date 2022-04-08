import axios from "axios";
import store from "../store";

const apiClient = axios.create({
    baseURL: "http://localhost:8888",
    withCredentials: false,
    headers: {
        Accept: "application/json",
        'Content-Type': 'application/json'
    }
})

export default {
    
    async getToken(username, password){
        try {
            const response = await apiClient.post("/auth/token", {
                username: username,
                password: password
            });
            return response.data;
        } catch {
            return "Wrong credentials";
        }
    },


    async postCalculation(number1, sign, number2){
        try {
            const response = await apiClient
                .post("/equation/calculate/", {
                    first_number: number1,
                    sign: sign,
                    second_number: number2,
                    username: store.state.username
                }, {
                    headers: {
                        Authentication: `Bearer ${store.state.token}`
                    }
                });
            return response.data;
        } catch {
            return "Unable to calculate";
        }
    },

    async getHistoryCalc() {
        try {
            const response = await apiClient.get("/equation/history/" + `${store.state.username}`, {
                headers: {
                    Authentication: `Bearer ${store.state.token}`
                }
            });
            return response.data;
        } catch {
            return false;
        }
    }
}
