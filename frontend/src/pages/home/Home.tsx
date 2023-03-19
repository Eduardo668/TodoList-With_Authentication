import { useState } from "react";
import { useMutation } from "react-query";
import { CreateUser } from "../../api/createUser";
import { Login } from "../../api/login";
import { FormComponent } from "../../components/form-component/FormComponent";
import { GlobalStyle } from "../../global/globalstyles";
import { BoxHome, Container } from "./style";
export const Home = () => {
  const [username, setUsername] = useState<string>("");
  const [password, setPassword] = useState<string>("");

  const { mutate: createUser, isSuccess: isCreated } = useMutation(() =>
    CreateUser(username, password)
  );
  const {
    mutate: login,
    isSuccess: isLogged,
    data: tokens,
  } = useMutation(() => Login(username, password), {
    onError: ()=>{
      alert("Username or Password incorrects!!")
    }
  });

  if (isLogged) {
    console.log(tokens.data);
  }

  const handleUsername = (username: string) => {
    setUsername(username);
  };

  const handlePassword = (password: string) => {
    setPassword(password);
  };

  return (
    <>
      <Container>
       

        <BoxHome>
          <FormComponent
            handleUsername={handleUsername}
            handlePassword={handlePassword}
            submit={() => login()}
            title="Login"
          />
        </BoxHome>
        <div className="or">
          <h3>OR</h3>
        </div>
        <BoxHome>
          <FormComponent
            handleUsername={handleUsername}
            handlePassword={handlePassword}
            submit={() => createUser()}
            title="Register"
          />
        </BoxHome>
      </Container>
    </>
  );
};
