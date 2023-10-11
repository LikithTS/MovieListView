package com.vtu.movielist.repository

import com.vtu.movielist.model.QuestionMappingData
import com.vtu.movielist.model.Questions

interface QuestionsMapping {

    fun getVoluteersList(questions : Questions) : QuestionMappingData
}