<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 06-Sep-17
 * Time: 8:34 PM
 */

namespace App\Api\v1\Controllers;


use App\Api\V1\Requests\StudentTechnologyRequest;
use App\Api\V1\Transformers\StudentTechnologyTransformer;
use App\StudentTech;
use App\Technology;
use Dingo\Api\Routing\Helpers;
use Illuminate\Routing\Controller;

class StudentTechnologyController extends Controller
{
    use Helpers;

    public function add(StudentTechnologyRequest $request)
    {
        $studentTechnology = new StudentTech();
        $studentTechnology->student_id = $request->getStudentID();
        $studentTechnology->technology_id = $request->getTechnology();
        $studentTechnology->save();
        return $this->response->item($studentTechnology, new StudentTechnologyTransformer());
    }
}