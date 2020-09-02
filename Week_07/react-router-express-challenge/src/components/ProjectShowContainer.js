import React, { useState, useEffect } from "react"

import ProjectShow from "./ProjectShow"

const ProjectShowContainer = props => {
  const [project, setProject] = useState({})
  const projectId = props.match.params.id

  useEffect(() => {
    fetch(`/api/v1/projects/${projectId}`)
      .then(response => response.json())
      .then(responseData => {
        setProject(responseData)
      })
  }, [])

  return (
    <div>
      <ProjectShow key={projectId} project={project} />
    </div>
  )
}

export default ProjectShowContainer
