import React from "react"

const ProjectTile = ({ project: { name, description } }) => {
  return (
    <div className="row">
      <div className="project small-9 small-centered columns">
        <h2>{name}</h2>
        <h3>Description: {description} </h3>
      </div>
    </div>
  )
}

export default ProjectTile
