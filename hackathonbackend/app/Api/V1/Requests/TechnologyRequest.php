<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 06-Sep-17
 * Time: 4:51 PM
 */

namespace App\Api\V1\Requests;


use App\Contracts\AddTechnology;

class TechnologyRequest extends Request implements AddTechnology
{
    const TECHNOLOGY = 'technology';
    const STUDENT_ID='student_id';

    public function addTechnology()
    {
        // TODO: Implement addTechnology() method.
        return $this->get(self::TECHNOLOGY);
    }

    public function addStudentID()
    {
        // TODO: Implement addStudentID() method.
        return $this->get(self::STUDENT_ID);
    }
}