<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 2:53 AM
 */

namespace App\Api\V1\Transformers;


use App\StudentTech;
use App\StudentTechnology;
use App\Technology;
use League\Fractal\TransformerAbstract;

class StudentTechnologyTransformer extends TransformerAbstract
{


    public function transform(StudentTech $technology)
    {
        return [
            'id' => (int)$technology->id,
            'student_id' => (int)$technology->student_id,
            'technology_id' => $technology->technology_id
        ];
    }


}