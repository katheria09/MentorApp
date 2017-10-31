<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 12:30 AM
 */

namespace App\Api\V1\Requests;


use App\Contracts\AddloginDetails;

class LoginRequest extends Request implements AddloginDetails
{
    const EMAIL = 'email';
    const PASSWORD = 'password';

    public function getEmail()
    {
        // TODO: Implement getEmail() method.
        return $this->get(self::EMAIL);
    }


    public function getPassword()
    {
        // TODO: Implement getPassword() method.
        return $this->get(self::PASSWORD);
    }
}