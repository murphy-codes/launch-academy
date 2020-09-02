import React, { useState, useEffect } from "react"

import WorkTile from "./WorkTile"

const WorkExperienceContainer = props => {
  const [workExperiences, setWorkExperiences] = useState([])

  useEffect(() => {
    fetch("/api/v1/work_experiences.json")
      .then(response => response.json())
      .then(responseData => {
        setWorkExperiences(responseData)
      })
  }, [])

  const workExperienceTiles = workExperiences.map(workExperience => {
    return <WorkTile key={workExperience.id} workExperience={workExperience} />
  })

  return (
    <div className="work_experiences">
      <h1>Past Work</h1>
      {workExperienceTiles}
    </div>
  )
}

export default WorkExperienceContainer
