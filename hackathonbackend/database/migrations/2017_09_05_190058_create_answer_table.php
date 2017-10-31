<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateAnswerTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('answer', function(Blueprint $table)
        {
            $table->increments('id');
            $table->unsignedInteger('question_id');
            $table->string('answer');
            $table->unsignedInteger('mentor_id');
            $table->unsignedInteger('upvote')->default(0);
            $table->unsignedInteger('downvote')->default(0);
            $table->unsignedInteger('weight')->default(0);
            $table->integer('karma_points')->default(0);
            $table->timestamps();
            $table->foreign('question_id')->references('id')->on('question')->onDelete('cascade');
            $table->foreign('mentor_id')->references('id')->on('mentor')->onDelete('cascade');

        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('answer');
    }
}
