import React from "react"

import SkillsContainer from "./SkillsContainer"
import VolunteerExperienceContainer from "./VolunteerExperienceContainer"
import WorkExperienceContainer from "./WorkExperienceContainer"
import EducationExperienceContainer from "./EducationExperienceContainer"

const Resume = props => {
  return (
    <div className="small-12 small-centered columns">
      <h1 className="page-title text-center"> Jane Jupiter, Developer </h1>
      <div className="small-3 columns">
        <h3>
          <a href="#">Skills</a>
        </h3>
      </div>
      <div className="small-3 columns">
        <h3>
          <a href="#">Education</a>
        </h3>
      </div>
      <div className="small-3 columns">
        <h3>
          <a href="#">Past Work</a>
        </h3>
      </div>
      <div className="small-3 columns">
        <h3>
          <a href="#">Volunteer Experience</a>
        </h3>
      </div>

      <div className="resume-section" id="skills">
        <SkillsContainer />
      </div>
      <div className="resume-section" id="education">
        <EducationExperienceContainer />
      </div>
      <div className="resume-section" id="past-work">
        <WorkExperienceContainer />
      </div>
      <div className="resume-section" id="volunteer-experience">
        <VolunteerExperienceContainer />
      </div>
    </div>
  )
}

export default Resume
