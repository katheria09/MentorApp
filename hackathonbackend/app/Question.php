<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 05-Sep-17
 * Time: 1:23 AM
 */

namespace App;


use Illuminate\Database\Eloquent\Model;

class Question extends Model
{
    protected $table = 'question';

    public function student(){
        return $this->belongsTo('App\Student');
    }
}