import { Api } from "./Api";
import { UserCredencials } from "../types/UserCredencias";
import { Login } from "./login";


export const CreateUser = async (username:string, password:string)=>{

    const newUser:UserCredencials= {
        "username": username,
        "password": password
    }

    const response = await Api.post("/api/user/create",newUser);

    if (response.status == 200){
        Login(username, password);
        
    }

   
}