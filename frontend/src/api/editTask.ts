import { Api } from "./Api"

export const EditTask = async (task_id:number, newTask:string)=>{

    const edited_task = {
        "title": newTask,
        "priority": null
    }

    const response = await Api.put(`/api/task/update/id=${task_id}`,edited_task, {
        headers:{
            "Authorization": `Bearer ${localStorage.getItem("access_token")}`
        }
    } )

    return response;

}