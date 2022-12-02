import styled from "styled-components";

export const Container = styled.div`
    width: 100%;
    height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    overflow-x: hidden;
    overflow-y: hidden;
    align-items: center;
    /* border: 2px solid red; */


`

export const Header = styled.div`
    width: 100%;
    height: 25vh;
    /* position: absolute; */
    /* border: 5px solid white; */
    display: flex ;
    flex-direction:column;
    justify-content: flex-start;
    align-items: center;
    background-color:#0D0D0D;
    .div-btn-quit{
        width: 100%;
        position: absolute;
        /* border: 1px solid red; */
        display: flex;
        justify-content: flex-start;
        align-items: center;
        .btn-quit{
            background-color: #1E6F9F;
            color: white;
            border: transparent;
            margin: 10px;
            padding: 5px 10px 5px 10px ;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
        }
    }

    h1{
        color: var(--textcolor);
        text-align: center;
        font-family: monospace;
        font-size: 2.5em;
        display: flex;
        justify-content: center;
        align-items: center;
        margin-left: 10px;
        margin-top: 2.5rem;
        @media(max-width: 500px){
            font-size: 2em;
        }
         @media(max-width: 400px){
            font-size: 1.7em;
        }
        /* margin-bottom: 20px; */
        /* border: 1px solid wheat; */


    }
    img{
        width: 40px;
        margin-top: 10px;
        padding-right: 10px;
    }
`

export const InputDiv = styled.div`
    width: 736px;
    height: 54px;
    position: absolute;
    top: 20vh;
    display: flex;
    /* border: 2px solid red; */
    @media (max-width: 736px){
        width: 500px;
    }
    @media (max-width: 500px){
        width: 350px;
    }
    input{
        background-color: #262626;
        border: 1px solid #0D0D0D;
        border-radius: 8px;
        width: 100%;
        color: #808080;
        font-size: 1.2em;
        padding-left: 20px;
        outline: none;
    }
    button{
        background-color: #1E6F9F;
        border-radius: 8px;
        border: transparent;
        color:white;
        font-size: 1.3em;
        display: flex;
        justify-content: center;
        align-items:center;
        width: 150px;
        margin-left: 5px;
        cursor: pointer;
        padding-left: 20px;
        :hover{
            background-color:  #3d8dc1 ;
            transition: 0.5s ;
        }
        
        img{
            width: 20px;
            margin-bottom: 5px;
            margin-left: 10px;

        }

    }

` 

export const TaskContainer = styled.div`
    width:100%;
    height: 75vh;
    display: flex;
    /* border: 1px solid red; */
    flex-direction: column;
    justify-content: flex-end;
    align-items: center;
    .todolist-header{
        width: 50rem;
        /* border: 2px solid yellow; */
        height: 10vh;
        display: flex;
        justify-content: flex-start;
        align-items:center;
        @media (max-width: 805px){
        width: 40rem;
        }
        @media (max-width: 650px){
        width: 30rem;
        }
        @media (max-width: 490px){
        width: 22rem;
        }
        h3{
            color: var(--textcolor);
            font-family: monospace;
            font-size: 1.3em;
            margin-right:10px;
        }
        h4{
            width: 25px;
            height: 25px;
            background: #333333;
            border-radius: 999px;
            padding: 2px 8px;
            color: white;
            text-align: center;
            display: flex;
            font-size: 1.4em;
            justify-content: center;
            align-items: center;
            font-family: monospace;
        }        
    }

`
export const TodoListBox = styled.div`
    display: flex;
    width: 50rem;
    height: 80%;
    overflow-y: scroll;
    overflow-x: hidden;

    .div-not-tasks{
        width: 100%;
        height: 100%;
        display: flex;
        justify-content: center;
        margin-bottom: 10rem;
        align-items: center;
        flex-direction: column;
        .text-not{
            font-family: monospace;
            color: #808080;
            font-size: 2em;
        }
    }


     ::-webkit-scrollbar{
        width: 5px;
        background-color: black;
     }
     ::-webkit-scrollbar-thumb{
        height: 10px;
        border-radius: 10px;
        background-color: gray;
     }
        
   
     
   
    /* border: 2px solid blue; */
    flex-direction: column;
    @media (max-width: 805px){
        width: 40rem;
    }
    @media (max-width: 650px){
        width: 30rem;
    }
    @media (max-width: 490px){
        width: 22rem;
    }


    

    .tasks-list{
        display: flex;
        width: 100%;
        height: 100vh;
        /* border: 2px solid purple; */
        flex-direction: column;
    }

`