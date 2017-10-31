<?php
/**
 * Created by PhpStorm.
 * User: user
 * Date: 07-Sep-17
 * Time: 2:30 AM
 */

namespace App;


use Illuminate\Database\Eloquent\Model;

class Invites extends Model
{
    protected $table = 'invites';

    public function mentor(){
        return $this->belongsTo('App\Mentor');
    }

    public function student(){
        return $this->belongsTo('App\Student');
    }
}