import axios from "axios";

export const Api = axios.create({
    baseURL: "https://todolist-api-iq73.onrender.com"
})
