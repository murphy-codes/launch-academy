import React, { useState, useEffect } from 'react';

const LauncherShow = (props) => {
  const [launcher, setLauncher] = useState({})

  useEffect(() => {
    fetch(`/api/v1/launchers/${props.match.params.id}`)
      .then(response => {
        if (response.ok) {
          return response;
        } else {
          let errorMessage = `${response.status} (${response.statusText})`,
            error = new Error(errorMessage);
          throw (error);
        }
      })
      .then(response => response.json())
      .then(fetchedLauncher => {
        setLauncher(fetchedLauncher)
      })
      .catch(error => console.error(`Error in fetch: ${error.message}`));
  }, [])

  return(
    <div className='page'>
      <div id="launchers-wrapper">
        <h2 className="launcher">{launcher.name}</h2>
        <h3 className="tangerine">Bio: </h3>
        <p className="tangerine">{launcher.bio}</p>
    </div>
    </div>
  )
}

export default LauncherShow;