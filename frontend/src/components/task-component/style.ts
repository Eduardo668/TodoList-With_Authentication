import styled from "styled-components";

export const Container = styled.div`
    width: 97%;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 13vh;
    border: 1px solid #333333;
    background-color: #262626;
    border-radius: 8px;
    padding-left:15px;
    margin-bottom: 10px;


`
export const BoxTask = styled.div`
    display: flex;
    justify-content: flex-start;
    align-items: ${props => props.theme.align};
    width: ${props => props.theme.width};
    height: 100%;
    /* border: 2px solid white; */
    h3{
        color:white;
        font-family: monospace;
    }

    .div-btn{
        width: 45%;
        height: 100%;
        display: flex;
        /* border: 2px solid red; */
        flex-direction:column;
        justify-content: center;
        align-items: center;
        label{
            color: var(--textcolor);
            font-family: monospace;
            font-size: 1.2em;
            font-weight: bold;
            margin-bottom: 10px;
        }
        select{
            background-color: black;
            color: white;
            border: transparent;
            border-radius: 5px;
        }
    }
    .btn-delete{
        background-color: transparent;
        border: transparent;
        cursor: pointer;
        
    }

`