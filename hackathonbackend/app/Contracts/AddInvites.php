<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 07-Sep-17
 * Time: 2:45 AM
 */

namespace App\Contracts;


interface AddInvites
{
    public function studentID();

    public function mentorID();

    public function studentStatus();

    public function mentorStatus();
}