import React, { useState, useEffect } from 'react';
import { Link } from "react-router-dom"

const LauncherList = (props) => {
  const [launchers, setLaunchers] = useState([])

  useEffect(() => {
    fetch('/api/v1/launchers')
      .then(response => {
        if (response.ok) {
          return response;
        } else {
          let errorMessage = `${response.status} (${response.statusText})`,
              error = new Error(errorMessage);
          throw(error);
        }
      })
      .then(response => response.json())
      .then(body => {
        setLaunchers(body);
      })
      .catch(error => console.error(`Error in fetch: ${error.message}`));
  },[])

  const launcherList = launchers.map(launcher => {
    return(
      <li key={launcher.id}>
        <Link to={`/launchers/${launcher.id}`} className="launcher launcher-link">{launcher.name}</Link>
      </li>
    )
  })

  return(
    <div className='page'>
      <ul id="launchers-wrapper">
        {launcherList}
      </ul>
    </div>
  )
}

export default LauncherList;