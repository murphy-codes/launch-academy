import style from "./styles/app.scss"
import React from "react"
import ReactDOM from "react-dom"
import App from './components/EventManagementApp';
import events from './constants/events.js';
ReactDOM.render(
  <App events={events}/>,
  document.getElementById("app")
)