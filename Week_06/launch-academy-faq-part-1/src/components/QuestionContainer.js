import React, { useState } from 'react';
import QuestionTile from "./QuestionTile";

const QuestionContainer = (props) => {
  const [selectedQuestionId, setSelectedQuestionId] = useState(null);

  const questionTileArray = props.data.map(questionData => {
    let visible = (questionData.id === selectedQuestionId) ? true : false;

    // Select this question, making it visible and others not
    const handleClick = () => { 
      if(questionData.id === selectedQuestionId) {
        setSelectedQuestionId(null);
      } else {
        setSelectedQuestionId(questionData.id);
      };
    };

    return (
      <QuestionTile
        key={questionData.id}
        question={questionData.question}
        answer={questionData.answer}
        handleClick={handleClick}
        visible={visible}
      />
    );
  });

  return <>{questionTileArray}</>;
};

export default QuestionContainer;