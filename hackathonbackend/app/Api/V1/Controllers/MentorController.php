<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 10:09 PM
 */

namespace App\Api\v1\Controllers;


use App\Api\V1\Requests\LoginRequest;
use App\Api\V1\Requests\MentorRequest;
use App\Api\V1\Transformers\LoginTransformer;
use App\Api\V1\Transformers\MentorTransformer;
use App\Api\V1\Transformers\MentorDetailTransformer;
use App\Mentor;
use Dingo\Api\Routing\Helpers;
use Illuminate\Routing\Controller;

class MentorController extends Controller
{
    use  Helpers;

    public function store(MentorRequest $request)
    {
        $mentor = new Mentor();
        $mentor->name = $request->getName();
        $mentor->email = $request->getEmail();
        $mentor->password = $request->getPassword();
        $mentor->save();
        return $this->response->item($mentor, new MentorTransformer());
    }

    public function authenticate(LoginRequest $request)
    {
        $user = Mentor::where('email', $request->getEmail())->where('password', $request->getPassword())->first();
        return $this->response->item($user, new LoginTransformer());
    }

    public function mentor()
    {
        $user = Mentor::all();
        return $this->response->collection($user, new MentorDetailTransformer());
    }

    public function getMentor($id){
        $user=Mentor::where('id',$id)->first();
        return $this->response->item($user,new MentorDetailTransformer());
    }


}