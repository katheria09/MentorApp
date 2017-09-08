<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 06-Sep-17
 * Time: 2:41 AM
 */

namespace App\Api\V1\Transformers;


use App\Answer;
use App\Mentor;
use League\Fractal\TransformerAbstract;

class AnswerTransformer extends TransformerAbstract
{
    protected $defaultIncludes = [
        'mentor'
    ];


    public function transform(Answer $signup)
    {
        return [
            'id' => (int)$signup->id,
            'question_id' => $signup->question_id,
            'mentor_id' => $signup->mentor_id,
            'answer' => $signup->answer,
            'upvote' => (int)$signup->upvote,
            'downvote' => (int)$signup->downvote,
            'weight' => $signup->weight,
            'karma_points' => $signup->karma_points,
            'created_at' => $signup->created_at->toDateTimeString(),
            'updated_at' => $signup->updated_at->toDateTimeString()
        ];
    }

    public function includeMentor(Answer $answer)
    {
        $mentor = $answer->mentor;
        return $this->item($mentor, new MentorDetailTransformer());
    }


}