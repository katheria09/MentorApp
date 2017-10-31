<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 10:04 PM
 */

namespace App\Contracts;


interface AddMentorDetails
{
    public function getName();

    public function getEmail();

    public function getPassword();
}