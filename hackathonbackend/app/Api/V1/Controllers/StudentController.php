<?php

namespace App\Api\v1\Controllers;

use App\Api\V1\Requests\LoginRequest;
use App\Api\V1\Requests\StudentRequest;
use App\Api\V1\Requests\StudentTechnologyRequest;
use App\Api\V1\Transformers\LoginTransformer;
use App\Api\V1\Transformers\QuestionTransformerAll;
use App\Api\V1\Transformers\StudentDetailTransformer;
use App\Api\V1\Transformers\StudentTechnologyTransformer;
use App\Api\V1\Transformers\MentorDetailTransformer;
use App\Student;
use App\StudentTechnology;
use App\Technology;
use Dingo\Api\Routing\Helpers;
use Illuminate\Routing\Controller;
use App\Api\V1\Transformers\StudentTransformer;


/**
 * Created by PhpStorm.
 * User: user
 * Date: 04-Sep-17
 * Time: 10:13 PM
 */
class StudentController extends Controller
{
    use Helpers;

    public function store(StudentRequest $request)
    {
        $signup = new Student();
        $signup->name = $request->getName();
        $signup->email = $request->getEmail();
        $signup->password = $request->getPassword();
        $signup->save();
        return $this->response->item($signup, new StudentTransformer());

    }

    public function authenticate(LoginRequest $request)
    {
        $user = Student::where('email', $request->getEmail())->where('password', $request->getPassword())->first();
        return $this->response->item($user, new LoginTransformer());
    }



    public function technology($id)
    {
        $user = Student::find($id);
        return $this->response->collection($user->technology, new StudentTechnologyTransformer());
    }


    public function student()
    {
        $user = Student::all();
        return $this->response->collection($user, new StudentDetailTransformer());
    }



}