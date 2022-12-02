import styled from "styled-components";

export const FormContainer = styled.div`
    width: 450px;
    height: 500px;
    background-color: #0D0D0D;
    display: flex;
    flex-direction: column;
    border-radius: 20px;
`

export const BoxForm = styled.div`
    width: 100%;
    flex-direction: column;
    display: flex;
    height: ${props => props.theme.height};
    /* border: 2px solid red; */
    justify-content: center;
    align-items: center;

    .title{
        color: var(--textcolor);
        font-size: 3.5em;
        font-family: monospace;
    }
    .btn-submit{
        font-size: 2.2em;
        border: 2px solid var(--textcolor);
        border-radius:20px;
        background-color: black;
        color: white;
        cursor: pointer;
        padding: 10px 20px 10px 20px;
        :hover{
            background-color: var(--bgcolor);
            transition: 0.8s;
        }
    }


`

export const InputBox = styled.div`
    width: 80%;
    display: flex;
    flex-direction: column;
    /* border: 2px solid yellow; */
    height: 100%;
    label{
        color: var(--textcolor);
        font-family: monospace;
        font-size: 1.5em;
        font-weight: bold;
    }
    .form-inputs{
        border: 2px solid var(--textcolor);
        background-color: var(--bgcolor);
        height: 6vh;
        color: white;
        border-radius: 20px;
        outline: none;
        padding: 5px 20px 10px 20px;
        font-family: monospace;
        font-size: 1.6em;
    }
`
