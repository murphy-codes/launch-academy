import React, { useState } from 'react';

const FAQForm = (props) => {
  let [newFAQ, setNewFAQ] = useState({
    question: "",
    answer: ""
  });

  const handleInputChange = (event) => {
    setNewFAQ({
      ...newFAQ,
      [event.currentTarget.name]: event.currentTarget.value
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    props.handleFormSubmission(newFAQ);
    setNewFAQ({
      question: "",
      answer: ""
    })
  }

  return(
    <form onSubmit={handleSubmit} id="faq-form">
      <label htmlFor="question">Enter a new FAQ: </label>
      <input 
        name="question"
        value={newFAQ.question} 
        type="text" 
        onChange={handleInputChange}
      />
      
      <label htmlFor="answer">Enter the answer for this FAQ: </label>
      <input 
        name="answer" 
        value={newFAQ.answer} 
        type="text"
        onChange={handleInputChange}
      />

      <input type="submit" value="Submit your FAQ!" />
    </form>
  )
}

export default FAQForm