<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 1:20 AM
 */

namespace App\Contracts;


interface AddQuestion
{
    public function senderID();

    public function question();

    public function tech();

}