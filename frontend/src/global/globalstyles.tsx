import { createGlobalStyle } from "styled-components";

export const GlobalStyle = createGlobalStyle`
    :root{
        --textcolor: #4EA8DE;
        --bgcolor:#1a1a1a;
    }
    body{
        background-color: var(--bgcolor);
        margin: 0;
        padding: 0;
    }

    

`;