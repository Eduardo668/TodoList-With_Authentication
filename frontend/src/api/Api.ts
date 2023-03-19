import axios from "axios";

export const Api = axios.create({
    baseURL: "http://ec2-18-228-193-248.sa-east-1.compute.amazonaws.com:8080"
})
