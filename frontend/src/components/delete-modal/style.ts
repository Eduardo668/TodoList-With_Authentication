import styled from "styled-components";

export const Container = styled.div`
    width: 100%;
    position: absolute;
    z-index: 1000;
    height: 100vh;
    display: flex;
    background-color: rgb(0 ,0 , 0, 0.5);
    justify-content: center;
    align-items: center;
`
export const Modal = styled.div`
    width: 400px;
    height: 100px;
    border-radius: 10px;
    background-color: var(--bgcolor);
    border: 2px solid var(--textcolor);
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 20px;
    .text-div{
        width: 100%;
        height: 100%;

    }
    .btn-div{
        width: 100%;
        height: 80%;
        display: flex;
        /* border: 1px solid white; */
        justify-content: center;
        align-items: center;
    }
    h3{
        color: white;
        font-family: monospace;
        font-size: 1.4em;

    }
    .yes-btn{
        font-size: 1.4em;
        width: 100px;
        height: 50px;
        margin: 20px;
        border: 2px solid var(--textcolor);
        background-color: black;
        color: white;
        border-radius: 10px;
        cursor: pointer;
        :hover{
            background-color: gray;
            transition: 0.6s ;
        }
    }
`