<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 06-Sep-17
 * Time: 11:26 AM
 */

namespace App\Api\V1\Transformers;


use App\Student;
use League\Fractal\TransformerAbstract;

class StudentDetailTransformer extends TransformerAbstract
{
    public function transform(Student $signup)
    {
        return [
            'id' => (int)$signup->id,
            'name' => $signup->name,
            'email' => $signup->email,
            'created_at' => $signup->created_at->toDateTimeString(),
            'updated_at' => $signup->updated_at->toDateTimeString()
        ];
    }
}