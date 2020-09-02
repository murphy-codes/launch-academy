import React, { useState, useEffect } from "react"

import SkillTile from "./SkillTile"

const SkillsContainer = props => {
  const [skills, setSkills] = useState([])

  useEffect(() => {
    fetch("/api/v1/skills.json")
      .then(response => response.json())
      .then(responseData => {
        setSkills(responseData)
      })
  }, [])

  const skillTiles = skills.map(skill => {
    return <SkillTile key={skill.id} skill={skill} />
  })

  return (
    <div className="skills">
      <h1>Skills</h1>
      {skillTiles}
    </div>
  )
}

export default SkillsContainer
