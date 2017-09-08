<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 07-Sep-17
 * Time: 2:43 AM
 */

namespace App\Api\v1\Controllers;
use App\Api\V1\Requests\InvitesRequest;
use App\Api\V1\Transformers\InvitesTransformer;
use App\Invites;
use Dingo\Api\Routing\Helpers;
use Illuminate\Routing\Controller;

class InvitesController extends Controller
{
    use Helpers;

    public function store(InvitesRequest $request)
    {
        $invites = new Invites();
        $invites->student_id = $request->studentID();
        $invites->mentor_id = $request->mentorID();
        $invites->mentor_status = $request->mentorStatus();
        $invites->student_status = $request->studentStatus();
        $invites->save();
        return $this->response->item($invites, new InvitesTransformer());
    }

    public function inviteStudent($student_id)
    {
        $invites = Invites::where('student_id', $student_id)->get();
        return $this->response->collection($invites, new InvitesTransformer());
    }


    public function inviteMentor($mentor_id)
    {
        $invites = Invites::where('mentor_id', $mentor_id)->get();
        return $this->response->collection($invites, new InvitesTransformer());
    }

    public function updateStudentStatus(InvitesRequest $request)
    {
        $invite = Invites::where('student_id', $request->studentID())->pluck('student_status');
        $i = Invites::where('student_id', $request->studentID())->where('mentor_id',$request->mentorID())->update(['student_status' => $request->studentStatus()]);
        $invites = Invites::where('student_id', $request->studentID())->where('mentor_id',$request->mentorID())->first();
        return $this->response->item($invites, new InvitesTransformer());
    }

    public function updateMentorStatus(InvitesRequest $request)
    {
        $invite = Invites::where('mentor_id', $request->mentorID())->pluck('mentor_status');
        $i = Invites::where('student_id', $request->mentorID())->where('mentor_id',$request->mentorID())->update(['mentor_status' => $request->mentorStatus()]);
        $invites = Invites::where('student_id', $request->studentID())->where('mentor_id',$request->mentorID())->first();
        return $this->response->item($invites, new InvitesTransformer());
    }
}