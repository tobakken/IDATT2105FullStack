import axios from "axios";

const apiClient = axios.create({
    baseURL: "http://localhost:8888",
    withCredentials: false,
    headers: {
        Accept: "application/json",
        'Content-Type': 'application/json'
    }
})

export default {
    postCalculation(number1, sign, number2, id){
        return apiClient
            .post("/equation/calculate/", {
                first_number: number1,
                sign: sign,
                second_number: number2,
                id: id
            }).then((response) => {
                return response.data
            })
            .catch(() => {
                return "Unable to calculate"
            })
    },

    getHistoryCalc(id) {
        return apiClient.get("equation/history/" + `${id}`).then((response) => {
            return response.data
        })
        .catch(() => {
            return false
        })
    }
}
