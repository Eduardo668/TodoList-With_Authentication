import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import { GlobalStyle } from "./global/globalstyles";
import { Navigation } from "./routes";
import { QueryClient, QueryClientProvider } from "react-query";
const queryClient = new QueryClient();

ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
  <BrowserRouter>
    <QueryClientProvider client={queryClient} >
      <Navigation />
    </QueryClientProvider>
    <GlobalStyle />
  </BrowserRouter>
);
