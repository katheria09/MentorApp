<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 1:25 AM
 */

namespace App\Api\V1\Requests;


use App\Contracts\AddQuestion;

class QuestionRequest extends Request implements AddQuestion
{
    const SENDER_ID='student_id';
    const QUESTION='question';
    const TECHNOLOGY='technology';

    public function senderID()
    {
        // TODO: Implement senderID() method.
        return $this->get(self::SENDER_ID);
    }



    public function question()
    {
        // TODO: Implement question() method.
        return $this->get(self::QUESTION);
    }

    public function tech()
    {
        // TODO: Implement tech() method.
        return $this->get(self::TECHNOLOGY);
    }
}