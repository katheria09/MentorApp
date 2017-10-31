<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 06-Sep-17
 * Time: 12:28 AM
 */

namespace App;


use Illuminate\Database\Eloquent\Model;

class Answer extends Model
{
    protected $table = 'answer';

    public function mentor(){
        return $this->belongsTo('App\Mentor');
    }

    public function student(){
        return $this->belongsTo('App\Student');
    }
}