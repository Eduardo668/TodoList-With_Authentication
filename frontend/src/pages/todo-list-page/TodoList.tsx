import {
  Container,
  Header,
  InputDiv,
  TaskContainer,
  TodoListBox,
} from "./style";
import Rocket from "../../assets/rocket.svg";
import Plus from "../../assets/plus.svg";
import { Task } from "../../components/task-component/Task";
import { DeleteModal } from "../../components/delete-modal/DeleteModal";
import { useState } from "react";
import { EditModal } from "../../components/edit-modal/EditModal";
import Clipboard from "../../assets/Clipboard.svg";
import { useMutation, useQuery, useQueryClient } from "react-query";
import { FindUser } from "../../api/findUser";
import { UserModel } from "../../types/UserModel";
import { CreateTask } from "../../api/createTask";
import { useNavigate } from "react-router-dom";
import { DeleteTask } from "../../api/deleteTask";
import { EditTask } from "../../api/editTask";

export const TodoListPage = () => {
  const [showDeleteModal, setShowDeleteModal] = useState<boolean>(false);
  const [showEditModal, setShowEditModal] = useState<boolean>(false);
  const [task, setTask] = useState<string>("");
  const [task_id, setTaskId] = useState<number>(0);
  const [new_title, setNewTitle] = useState<string>("");
  const [title_now, setTitleNow] = useState<string>("");

  const openDeleteModal = (task_id:number) => {
    setTaskId(task_id);
    setShowDeleteModal(true);
  };
  const closeDeleteModal = () => {
    setShowDeleteModal(false);
   
  };
  const openEditModal = (task_id:number, title_now:string) => {
    setTaskId(task_id);
    setTitleNow(title_now);
    setShowEditModal(true);
  };
  const closeEditModal = () => {
    setShowEditModal(false);
  };
  const handleTask = (task:string)=>{
    setTask(task);
  }
  const handleNewTitle = (new_title:string)=>{
    setNewTitle(new_title);
  }

  const navigate = useNavigate()

  const quit = ()=>{
    localStorage.removeItem("access_token");
    localStorage.removeItem("refresh_token");
    localStorage.removeItem("user_id");
    navigate("/")

  }

  const queryClient = useQueryClient();
  const { data: user_data } = useQuery("user", () => FindUser());
  const {mutate:createTask}= useMutation(()=>CreateTask(task), {
    onSuccess: ()=> {
       queryClient.invalidateQueries("user");
    }
  });

  const {mutate:deleteTask} = useMutation(()=>DeleteTask(task_id), {
     onSuccess: ()=>{
        closeDeleteModal();
        queryClient.invalidateQueries("user");
     }
  })

  const {mutate:editTask} = useMutation(()=>EditTask(task_id, new_title), {
      onSuccess: ()=>{
         closeEditModal();
         queryClient.invalidateQueries("user");
      } 
  })

  

  return (
    <>
      {showDeleteModal ? (
        <DeleteModal deleteTask={()=>deleteTask()} closeDeleteModal={closeDeleteModal} />
      ) : null}
      {showEditModal ? <EditModal handleNewTitle={handleNewTitle} title={title_now} editTask={()=>editTask()} closeEditModal={closeEditModal} /> : null}

      <Container>
        <Header>
          <div className="div-btn-quit">
            <button onClick={ quit } className="btn-quit">Quit</button>
          </div>
          <h1>
            <img src={Rocket} alt="" /> {user_data?.username}'s Todo List
          </h1>

          <InputDiv>
            <input onChange={ (e)=>handleTask(e.target.value) } placeholder="Add a new task" type="text" />
            <button onClick={ ()=>createTask() } >
              Create <img src={Plus} alt="" />
            </button>
          </InputDiv>
        </Header>
        <TaskContainer>
          <div className="todolist-header">
            <h3>Created Tasks</h3>
            <h4>{user_data?.tasks.length}</h4>
          </div>
          <TodoListBox>
            <div className="tasks-list">
              {user_data?.tasks?.length != 0 ?  (
                user_data?.tasks?.map((task) => (
                  <Task
                    key={task.id}
                    task={task}
                    openEditModal={openEditModal}
                    openDeleteModal={openDeleteModal}
                  />
                ))
              ) : (
                <div className="div-not-tasks">
                  <img src={Clipboard} alt="" />
                  <h3 className="text-not">You haven't created any tasks</h3>
                </div>
              )}
            </div>
          </TodoListBox>
        </TaskContainer>
      </Container>
    </>
  );
};
