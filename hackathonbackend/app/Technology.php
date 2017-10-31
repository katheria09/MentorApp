<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 2:44 AM
 */

namespace App;


use Illuminate\Database\Eloquent\Model;

class Technology extends Model
{
    protected $table = 'technology';

    public function student(){
        return $this->belongsToMany('App\Student','tech_student','technology_id','student_id');
    }
}