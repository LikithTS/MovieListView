package com.vtu.movielist.repository

import com.vtu.movielist.model.QuestionMappingData
import com.vtu.movielist.model.Questions

class QuestionsMappingImpl : QuestionsMapping {
    override fun getVoluteersList(questions: Questions): QuestionMappingData {
        return QuestionMappingData()
    }
}