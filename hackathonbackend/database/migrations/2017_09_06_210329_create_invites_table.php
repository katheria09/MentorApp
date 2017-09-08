<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateInvitesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('invites', function(Blueprint $table)
        {
            $table->increments('id');
            $table->unsignedInteger('student_id');
            $table->unsignedInteger('mentor_id');
            $table->string('student_status');
            $table->string('mentor_status');
            $table->timestamps();
            $table->foreign('student_id')->references('id')->on('student')->onDelete('cascade');
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
        Schema::dropIfExists('invites');

    }
}
