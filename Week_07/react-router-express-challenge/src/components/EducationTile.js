import React from "react"

const EducationTile = ({
  educationExperience: {
    institution,
    course_title,
    degree,
    start_date,
    end_date
  }
}) => {
  const formattedStartDate = new Date(start_date).toDateString()
  const formattedEndDate = new Date(end_date).toDateString()
  return (
    <div className="education-tile">
      <h2>{institution}</h2>
      <h3>Course Title (if applicable): {course_title}</h3>
      <h3>Degree (if applicable): {degree}</h3>
      <h3>
        Time period: {formattedStartDate}-{formattedEndDate}
      </h3>
    </div>
  )
}

export default EducationTile
