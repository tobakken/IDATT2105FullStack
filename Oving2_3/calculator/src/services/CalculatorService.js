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
    getCalculation(number1, sign, number2){
        return apiClient
            .get("/calculate/" + number1 + "/" + sign + "/" + number2)
    },

    getPrevCalc() {
        return apiClient.get("/previousCalc")
    }
}
