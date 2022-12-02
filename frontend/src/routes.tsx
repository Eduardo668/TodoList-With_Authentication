import { useEffect } from "react"
import {Route, Routes, useNavigate} from "react-router-dom"
import { Home } from "./pages/home/Home"
import { TodoListPage } from "./pages/todo-list-page/TodoList"

const ReloadPage = ()=>{
     const navigate = useNavigate()

    useEffect(()=>{
        navigate("/")
    }, [])

    return(
        <>
        </>
    )
}

export const Navigation = ()=>{

   

    return(
        <>
            <Routes>
                <Route path="/" element={<Home />} />
                 {
                    localStorage.getItem("access_token") != undefined ? (
                        <Route path="/todo-list" element={<TodoListPage />} />
                    ) : <Route path="/todo-list" element={<ReloadPage />}  />
                 }
                
            </Routes>
        </>
    )
}