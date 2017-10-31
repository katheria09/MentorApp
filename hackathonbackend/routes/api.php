<?php

use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

$api = app('Dingo\Api\Routing\Router');

$api->version('v1', function ($api) {
//    $api->get('/test', function () {
//        return 'dingo working';
//    });

    $api->post('/signup/student', 'App\Api\V1\Controllers\StudentController@store');
    $api->post('/signup/mentor', 'App\Api\V1\Controllers\MentorController@store');
    $api->post('/question', 'App\Api\V1\Controllers\QuestionController@store');
    $api->post('/answer', 'App\Api\V1\Controllers\AnswerController@store');
    $api->post('/answer/upvote/{answer_id}', 'App\Api\V1\Controllers\AnswerController@upvote');
    $api->post('/answer/downvote/{answer_id}', 'App\Api\V1\Controllers\AnswerController@downvote');
    $api->get('/answer/{question_id}', 'App\Api\V1\Controllers\AnswerController@getAnswers');
    $api->post('/technology', 'App\Api\V1\Controllers\TechnologyController@store');
    $api->post('/technology/student', 'App\Api\V1\Controllers\StudentTechnologyController@add');
    $api->post('/invite', 'App\Api\V1\Controllers\InvitesController@store');
    $api->post('/invite/status/student/update', 'App\Api\V1\Controllers\InvitesController@updateStudentStatus');
    $api->post('/invite/status/mentor/update', 'App\Api\V1\Controllers\InvitesController@updateMentorStatus');
    $api->get('/invite/student/{student_id}', 'App\Api\V1\Controllers\InvitesController@inviteStudent');
    $api->get('/invite/mentor/{mentor_id}', 'App\Api\V1\Controllers\InvitesController@inviteMentor');
    $api->get('/technology/all', 'App\Api\V1\Controllers\TechnologyController@index');
    $api->get('/authenticate/student', 'App\Api\V1\Controllers\StudentController@authenticate');
    $api->get('/authenticate/mentor', 'App\Api\V1\Controllers\MentorController@authenticate');
    $api->get('/question/all', 'App\Api\V1\Controllers\QuestionController@index');
    $api->get('/mentor/all', 'App\Api\V1\Controllers\MentorController@mentor');
    $api->get('/question/{technology}', 'App\Api\V1\Controllers\QuestionController@questionTechnology');
    $api->get('/mentor/{id}', 'App\Api\V1\Controllers\MentorController@getMentor');
    $api->get('/student/all', 'App\Api\V1\Controllers\StudentController@student');
    $api->get('/question/student/{student_id}', 'App\Api\V1\Controllers\QuestionController@questionsAll');
});




