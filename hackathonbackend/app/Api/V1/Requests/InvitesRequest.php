<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 07-Sep-17
 * Time: 2:48 AM
 */

namespace App\Api\V1\Requests;


use App\Contracts\AddInvites;

class InvitesRequest extends Request implements AddInvites
{
    const STUDENT_ID = 'student_id';
    const MENTOR_ID = 'mentor_id';
    const STUDENT_STATUS='student_status';
    const MENTOR_STATUS='mentor_status';

    public function studentID()
    {
        // TODO: Implement studentID() method.
        return $this->get(self::STUDENT_ID);

    }

    public function mentorID()
    {
        // TODO: Implement mentorID() method.
        return $this->get(self::MENTOR_ID);
    }

    public function studentStatus()
    {
        // TODO: Implement studentStatus() method.
        return $this->get(self::STUDENT_STATUS);
    }

    public function mentorStatus()
    {
        // TODO: Implement mentorStatus() method.
        return $this->get(self::MENTOR_STATUS);
    }
}