import { Api } from "./Api"

export const DeleteTask = async (task_id:number | undefined)=>{

    const response = await Api.delete(`/api/task/delete/id=${task_id}`, {
        headers: {
            "Authorization": `Bearer ${localStorage.getItem("access_token")}`
        }
    })

    return response;

}