<?php

/**
 * Created by PhpStorm.
 * User: user
 * Date: 04-Sep-17
 * Time: 9:31 PM
 */

namespace App;


use Illuminate\Database\Eloquent\Model;

class Student extends Model
{
    protected $table = 'student';

    public function question()
    {
        return $this->hasMany('App\Question');
    }

//    public function technology()
//    {
//        return $this->hasMany('App\Technology');
//    }


}