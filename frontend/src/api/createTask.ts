import { Api } from "./Api"

export const CreateTask = async (title:string)=>{

    const newTask = {
        "title" : title,
        "priority": "anything"
    }

    const response = await Api.put(`/api/user/add-task/id=${localStorage.getItem("user_id")}`, newTask, {
        headers: {
            "Authorization": `Bearer ${localStorage.getItem("access_token")}`
        }
    })

    return response;

}