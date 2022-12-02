import { Api } from "./Api"
import { UserCredencials } from "../types/UserCredencias"
import jwtDecode from "jwt-decode";


export const Login = async (username:string, password:string)=>{

    const credencials:UserCredencials = {
        "username": username,
        "password": password
    } 

    const login_form_url = new URLSearchParams(credencials);
    

    const response = await Api.post("/login", login_form_url)

    if (response.status == 200){

        const access_token:string = response.data["access_token"];
        const refresh_token:string = response.data["refresh_token"];
        const decoded_jwt:any = jwtDecode(access_token);
        const user_logged:string = decoded_jwt["sub"];

        localStorage.setItem("access_token", access_token);
        localStorage.setItem("refresh_token", refresh_token);
        localStorage.setItem("user_id", user_logged);

        window.location.href = "/todo-list"
    }

    return response;

}