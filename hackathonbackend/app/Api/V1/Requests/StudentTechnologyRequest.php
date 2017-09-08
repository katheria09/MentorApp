<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 2:50 AM
 */

namespace App\Api\V1\Requests;


use App\Contracts\AddStudentTechnology;

class StudentTechnologyRequest extends Request implements AddStudentTechnology
{
    const STUDENT_ID = 'student_id';
    const TECHNOLOGY = 'technology_id';

    public function getTechnology()
    {
        // TODO: Implement getTechnology() method.
        return $this->get(self::TECHNOLOGY);
    }

    public function getStudentID()
    {
        // TODO: Implement getSenderID() method.
        return $this->get(self::STUDENT_ID);

    }
}