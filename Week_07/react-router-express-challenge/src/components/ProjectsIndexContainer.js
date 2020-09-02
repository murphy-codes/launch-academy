import React, { useEffect, useState } from "react"

import ProjectTile from "./ProjectTile"

const ProjectsIndexContainer = props => {
  const [projects, setProjects] = useState([])

  useEffect(() => {
    fetch("/api/v1/projects.json")
      .then(response => response.json())
      .then(responseData => {
        setProjects(responseData)
      })
  }, [])

  const projectTiles = projects.map(project => {
    return <ProjectTile key={project.id} project={project} />
  })
  return (
    <div>
      <h2 className="text-center">My Projects</h2>
      {projectTiles}
    </div>
  )
}

export default ProjectsIndexContainer
