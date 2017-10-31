<?php namespace App\Api\V1\Requests;

use Dingo\Api\Http\FormRequest;

class Request extends FormRequest
{
    public function authorize()
    {
        return true;
    }


    public function rules()
    {
        return [

        ];
    }
}