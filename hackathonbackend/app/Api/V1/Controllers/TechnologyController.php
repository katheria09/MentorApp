<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 06-Sep-17
 * Time: 4:52 PM
 */

namespace App\Api\v1\Controllers;


use App\Api\V1\Requests\TechnologyRequest;
use App\Api\V1\Transformers\TechnologyTransformer;
use App\Http\Controllers\Controller;
use App\StudentTech;
use App\Technology;
use Dingo\Api\Routing\Helpers;

class TechnologyController extends Controller
{
    use Helpers;


    public function index(){
        $tech=Technology::all();

        return $this->response->collection($tech,new TechnologyTransformer());
    }

    public function store(TechnologyRequest $request){
        $technology=new Technology();
        $technology->id=$request->addStudentID();
        $technology->technology=$request->addTechnology();
        $technology->save();
        return $this->response->item($technology,new TechnologyTransformer());
    }
}