<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 1:27 AM
 */

namespace App\Api\v1\Controllers;


use App\Answer;
use App\Api\V1\Requests\QuestionRequest;
use App\Api\V1\Transformers\QuestionTransformer;
use App\Api\V1\Transformers\QuestionTransformerAll;
use App\Question;
use Dingo\Api\Routing\Helpers;
use Illuminate\Routing\Controller;

class QuestionController extends Controller
{
    use Helpers;

    public function store(QuestionRequest $request)
    {
        $question = new Question();
        $question->student_id = $request->senderID();
        $question->question = $request->question();
        $question->technology = $request->tech();
        $question->weight = 5;
        $question->save();
        return $this->response->item($question, new QuestionTransformer());
    }

    public function index()
    {
        $question = Question::all();
        return $this->response->collection($question, new QuestionTransformerAll());
    }

    public function questionTechnology($technology)
    {
        $ques = Question::where('technology', $technology)->get();
        return $this->response->collection($ques, new QuestionTransformerAll());
    }

    public function questionsAll($student_id)
    {
        $ques = Question::where('student_id', $student_id)->get();
        return $this->response->collection($ques, new QuestionTransformerAll());
    }

    private function weight()
    {
        $ans = new Answer();
        return $ans->weight;
    }

}