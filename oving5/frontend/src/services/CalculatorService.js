import axios from "axios";

const apiClient = axios.create({
    baseURL: "http://localhost:8080",
    withCredentials: false,
    headers: {
        Accept: "application/json",
        'Content-Type': 'application/json'
    }
})

export default {
    postCalculation(number1, sign, number2){
        return apiClient
            .post("/calculate/" + number1 + "/" + sign + "/" + number2)
    },

    getHistoryCalc() {
        return apiClient.get("/history")
    }
}
