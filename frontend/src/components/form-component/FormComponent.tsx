import { useEffect } from "react";
import { BoxForm, FormContainer, InputBox } from "./style";

type Props = {
  title: string;
  handleUsername: (username:string)=>void,
  handlePassword:(password:string)=>void,
  submit:()=>void,
};



export const FormComponent = ({ title, handleUsername, handlePassword, submit }: Props) => {

  

  return (
    <FormContainer>
      <BoxForm theme={{ height: "50%" }}>
        <h1 className="title">{title}</h1>
      </BoxForm>
      <BoxForm theme={{ height: "100%" }}>
        <InputBox>
          <label htmlFor="">Username</label>
          <input className="form-inputs" onChange={ (e)=>handleUsername(e.target.value) } type="text" />
        </InputBox>
        <InputBox>
          <label htmlFor="">Password</label>
          <input className="form-inputs" onChange={(e)=>handlePassword(e.target.value)} type="password" />
        </InputBox>
      </BoxForm>
      <BoxForm theme={{ height: "50%" }}>
            <button onClick={ ()=>submit() } className="btn-submit" >
                { 
                    title == "Login" ? "Enter" : "Create"
                }
            </button>
      </BoxForm>
    </FormContainer>
  );
};
