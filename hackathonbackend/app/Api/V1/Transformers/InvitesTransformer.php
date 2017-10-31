<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 07-Sep-17
 * Time: 2:56 AM
 */

namespace App\Api\V1\Transformers;


use App\Invites;
use League\Fractal\TransformerAbstract;

class InvitesTransformer extends TransformerAbstract
{
    protected $defaultIncludes = ['student', 'mentor'];

    public function transform(Invites $invites)
    {
        return [
            'id' => (int)$invites->id,
            'student_status' => $invites->student_status,
            'mentor_status' => $invites->mentor_status,
            'student_id' => $invites->student_id,
            'mentor_id' => $invites->mentor_id,
            'created_at' => $invites->created_at->toDateTimeString(),
            'updated_at' => $invites->updated_at->toDateTimeString()
        ];
    }

    public function includeStudent(Invites $invites)
    {
        $student = $invites->student;
        return $this->item($student, new StudentDetailTransformer());
    }

    public function includeMentor(Invites $invites)
    {
        $mentor = $invites->mentor;
        return $this->item($mentor, new MentorDetailTransformer());
    }



}