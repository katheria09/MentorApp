<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 10:06 PM
 */

namespace App\Api\V1\Requests;


use App\Contracts\AddMentorDetails;

class MentorRequest extends Request implements AddMentorDetails
{
    const NAME = 'name';
    const EMAIL = 'email';
    const PASSWORD = 'password';

    public function getName()
    {
        // TODO: Implement getName() method.
        return $this->get(self::NAME);
    }

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