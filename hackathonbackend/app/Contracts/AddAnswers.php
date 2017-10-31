<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 06-Sep-17
 * Time: 2:24 AM
 */

namespace App\Contracts;


interface AddAnswers
{
    public function getQuestionID();

    public function getAnswer();

    public function getAnswerBy();
}