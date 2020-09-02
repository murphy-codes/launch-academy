import React, { useState, useEffect } from "react"

import EducationTile from "./EducationTile"

const EducationExperienceContainer = props => {
  const [educationExperiences, setEducationExperiences] = useState([])

  useEffect(() => {
    fetch("/api/v1/education_experiences.json")
      .then(response => response.json())
      .then(responseData => {
        setEducationExperiences(responseData)
      })
  }, [])

  const educationTiles = educationExperiences.map(educationExperience => {
    return (
      <EducationTile
        key={educationExperience.id}
        educationExperience={educationExperience}
      />
    )
  })

  return (
    <div className="education">
      <h1>Education</h1>
      {educationTiles}
    </div>
  )
}

export default EducationExperienceContainer
