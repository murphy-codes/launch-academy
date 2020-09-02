import React from "react"
import Greeting from "./components/Greeting"
import Goodbye from "./components/Goodbye"
import NavBar from "./components/NavBar"
import CustomGreeting from "./components/CustomGreeting"

const App = props => {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/greeting" component={CerealsIndexPage} />
        <Route exact path="/custom-greeting" component={CerealsIndexPage} />
        <Route exact path="/goodbye" component={MilksIndexPage} />
      </Switch>
    </BrowserRouter>
  )
}

export default App
