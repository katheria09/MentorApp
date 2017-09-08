<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 12:28 AM
 */

namespace App\Contracts;


interface AddloginDetails
{
    public function getEmail();

    public function getPassword();

}