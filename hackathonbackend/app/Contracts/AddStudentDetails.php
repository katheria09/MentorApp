<?php

/**
 * Created by PhpStorm.
 * User: user
 * Date: 04-Sep-17
 * Time: 10:15 PM
 */
namespace App\Contracts;

interface AddStudentDetails
{
    public function getName();

    public function getEmail();

    public function getPassword();

}