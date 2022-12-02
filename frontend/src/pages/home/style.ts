import styled from "styled-components";

export const Container = styled.div`
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    /* border: 2px solid white; */
    .or{
        display: flex;
        /* height: 100vh; */
        justify-content: center;
        align-items: center;
        font-size: 3.5em;
        color: var(--textcolor);
        font-family: monospace;
        @media (max-width:970px){
            width: 100%;
            
        }
    }
    @media (max-width: 970px){
        flex-wrap: wrap;

    }
    .alert-modal{
        position: absolute;
        right:0;
        top: 0;
        margin: 20px;
    }


`
export const BoxHome = styled.div`
    width: 100%;
    display: flex;
    /* border:solid 1px white; */
    /* height: 100%; */
    justify-content: center;
    align-items: center;
`



