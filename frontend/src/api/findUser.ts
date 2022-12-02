import { UserModel } from "../types/UserModel";
import { Api } from "./Api"

export const FindUser = async ()=>{

    const response = await Api.get(`/api/user/findUserById/id=${localStorage.getItem("user_id")}`, {
        headers: {
            "Authorization": `Bearer ${localStorage.getItem("access_token")}`
        }
    })

    const data:UserModel = await response.data;

    return data;

}