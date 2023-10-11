package com.vtu.movielist.repository

import com.vtu.movielist.model.Question
import com.vtu.movielist.model.Questions
import com.vtu.movielist.model.Volunteer

class TestQuesitonnariesJsonData {

    fun setQuestionnaries(): Questions {
        val questionsList = listOf<Question>(
            Question("0", listOf("mac", "vs_code"), "how do i install vs code"),
            Question("1", listOf("python", "ai"), "how do i install vs code"),
            Question("2", listOf("c#", "game"), "how do i install vs code"),
            Question("3", listOf("java", "oops"), "how do i install vs code"),
            Question("4", listOf("python", "networking"), "how do i install vs code"),
            Question("5", listOf("c++", "networking"), "how do i install vs code"),
        )

        val voluteerList = listOf<Volunteer>(
            Volunteer("Sam5k", listOf("python", "networking")),
            Volunteer("djpat", listOf("ai")),
            Volunteer("jessg", listOf("java", "networking")),
            Volunteer("rayo", listOf("java", "networking")),
        )

        return Questions(questionsList, voluteerList)
    }

}