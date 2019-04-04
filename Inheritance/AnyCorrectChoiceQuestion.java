/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  Checks multiple answers from the user, it is correct if one of the multiple
 *  answers are correct
 */
class AnyCorrectChoiceQuestion extends Question {
    private String answer;
    private String text;

    public AnyCorrectChoiceQuestion()
    {

    answer = "";
    text = "";

    }


    
    public void setText(String questionText)
    {
        text = questionText;
    }

    
    public void setAnswer(String correctResponse)
    {
        answer = correctResponse;
    }

    
    public boolean checkAnswer(String response)
    {
        if(answer.contains(response))
        {
            QuestionsApp.score = QuestionsApp.score + 3;
            return true;

        }
        else
        {

                return false;
        }
    }

    
    public void display()
    {
        System.out.println(text);
    }

}
