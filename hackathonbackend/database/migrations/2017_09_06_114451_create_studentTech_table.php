<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateStudentTechTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('tech_student', function(Blueprint $table)
        {
            $table->increments('id');
            $table->unsignedInteger('student_id');
            $table->unsignedInteger('technology_id');
            $table->timestamps();
            $table->foreign('student_id')->references('id')->on('student')->onDelete('cascade');
            $table->foreign('technology_id')->references('id')->on('technology')->onDelete('cascade');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('tech_student');

    }
}
