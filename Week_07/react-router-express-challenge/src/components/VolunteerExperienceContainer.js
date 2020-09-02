import React, { useState, useEffect } from "react"

import VolunteerTile from "./VolunteerTile"

const VolunteerExperienceContainer = props => {
  const [volunteerExperiences, setVolunteerExperiences] = useState([])

  useEffect(() => {
    fetch("/api/v1/volunteer_experiences.json")
      .then(response => response.json())
      .then(responseData => {
        setVolunteerExperiences(responseData)
      })
  }, [])

  const volunteerTiles = volunteerExperiences.map(volunteerExperience => {
    return (
      <VolunteerTile
        key={volunteerExperience.id}
        volunteerExperience={volunteerExperience}
      />
    )
  })

  return (
    <div className="volunteer_experiences">
      <h1>Volunteer Experience</h1>
      {volunteerTiles}
    </div>
  )
}

export default VolunteerExperienceContainer
