import { BoxTask, Container } from "./style"
import { BsTrashFill } from "react-icons/bs"
import {MdEdit} from "react-icons/md"
import { TaskModel } from "../../types/TaskModel"
type Props = {
    openDeleteModal:(task_id:number)=>void,
    openEditModal:(task_id:number, title_now:string)=>void,
    task: TaskModel
}

export const Task = ({ openDeleteModal, openEditModal, task }:Props)=>{
    


    return (
        <>
            <Container>
                <BoxTask theme={ {
                    "width": "100%"
                } }>
                    <h3>{task.title}</h3>
                </BoxTask>
                <BoxTask  theme={ {
                    "width": "20%",
                    "align": "center"
                } }>
                    {/* <div className="div-btn" >
                        <label htmlFor="">Priority</label>
                        <select name="priority" >
                            <option style={{"display":"none"}} ></option>
                            <option value={"High"} >High</option>
                            <option value={"Medium"} >Medium</option>
                            <option value={"Low"} >Low</option>
                        </select>
                    </div> */}
                    <div className="div-btn" >
                        <button onClick={ ()=>openEditModal(task.id, task.title) } className="btn-delete">
                            <MdEdit size={"20px"} color="#808080" />
                        </button>
                    </div>
                    <div className="div-btn">
                        <button onClick={()=>openDeleteModal(task.id)} className="btn-delete">
                            <BsTrashFill size={"20px"} color="#808080" />
                        </button>
                    </div>

                </BoxTask>
            </Container>
        </>
    )
}