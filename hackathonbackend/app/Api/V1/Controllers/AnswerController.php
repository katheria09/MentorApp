<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 06-Sep-17
 * Time: 2:17 AM
 */

namespace App\Api\v1\Controllers;


use App\Answer;
use App\Api\V1\Requests\AnswerRequest;
use App\Api\V1\Transformers\AnswerTransformer;
use Dingo\Api\Routing\Helpers;
use Illuminate\Routing\Controller;

class AnswerController extends Controller
{
    use Helpers;
    public $answer;

    public function store(AnswerRequest $request)
    {
        $this->answer = new Answer();
        $this->answer->question_id = $request->getQuestionID();
        $this->answer->answer = $request->getAnswer();
        $this->answer->mentor_id = $request->getAnswerBy();
        $this->answer->weight = $this->weight();
        $this->answer->karma_points = $this->karma();
        $this->answer->save();
        return $this->response->item($this->answer, new AnswerTransformer());
    }

    public function getAnswers($question_id)
    {
        $ans = Answer::where('question_id', $question_id)->get();
        return $this->response->collection($ans, new AnswerTransformer());
    }

    private function weight()
    {
        return 0;
    }

    private function karma(){
        return 0;
    }

    public function upvote($answer_id)
    {
        $upvote = Answer::where('id', $answer_id)->pluck('upvote');
        $upvote=$upvote[0]+1;
        $ans = Answer::where('id', $answer_id)->update(['upvote' => $upvote]);
        $answer = Answer::where('id', $answer_id)->first();
        return $this->response->item($answer, new AnswerTransformer());
    }

    public function downvote($answer_id)
    {
        $downvote = Answer::where('id', $answer_id)->pluck('downvote');
        $downvote=$downvote[0]+1;
        $ans = Answer::where('id', $answer_id)->update(['downvote' => $downvote]);
        $answer = Answer::where('id', $answer_id)->first();
        return $this->response->item($answer, new AnswerTransformer());
    }
}