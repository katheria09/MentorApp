<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 10:20 PM
 */

namespace App\Api\V1\Transformers;


use App\Mentor;
use League\Fractal\TransformerAbstract;

class MentorTransformer extends TransformerAbstract
{
    public function transform(Mentor $signup)
    {
        return [
            'id' => (int)$signup->id,
            'name' => $signup->name,
            'email' => $signup->email,
            'password' => $signup->password,
            'registration' => 'successfull',
            'created_at' => $signup->created_at->toDateTimeString(),
            'updated_at' => $signup->updated_at->toDateTimeString()
        ];
    }

}