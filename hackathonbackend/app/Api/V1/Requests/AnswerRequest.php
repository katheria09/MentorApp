<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 06-Sep-17
 * Time: 2:32 AM
 */

namespace App\Api\V1\Requests;


use App\Contracts\AddAnswers;

class AnswerRequest extends Request implements AddAnswers
{
    const QUES_ID = 'question_id';
    const ANSWER = 'answer';
    const ANSWER_BY = 'mentor_id';

    public function getQuestionID()
    {
        // TODO: Implement getQuestionID() method.
        return $this->get(self::QUES_ID);
    }

    public function getAnswer()
    {
        // TODO: Implement getAnswer() method.
        return $this->get(self::ANSWER);
    }

    public function getAnswerBy()
    {
        // TODO: Implement getAnswerBy() method.
        return $this->get(self::ANSWER_BY);
    }
}