package com.vtu.movielist.repository

import com.vtu.movielist.model.QuestionMappingData
import com.vtu.movielist.model.QuestionMappingDataItem
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class QuestionMappingImplTest {

    lateinit var questionsMappingImpl: QuestionsMappingImpl
    lateinit var helper: TestQuesitonnariesJsonData

    @Before
    fun setup() {
        questionsMappingImpl = QuestionsMappingImpl()
        helper = TestQuesitonnariesJsonData()
    }

    @Test
    fun `get list of voluteers assigned to question based on there skills`() {

        val questions = helper.setQuestionnaries()
        val question = questions.questions
        val volunteer = questions.volunteers
        val assignedQuestions = QuestionMappingData()

        question?.forEach { que ->
            volunteer?.forEach { vol ->
                que?.tags?.forEach {
                    if (vol?.tags?.contains(it) == true) {
                        if (assignedQuestions.size > 0)
                            if (assignedQuestions.contains(
                                    QuestionMappingDataItem(
                                        que.id,
                                        vol.id
                                    )
                                )
                            ) {

                            }
                    } else {
                        assignedQuestions.add(QuestionMappingDataItem(que.id, vol?.id))
                    }
                }
            }
        }
    }

    @Test
    fun `check for array of numbers`() {
        val testData = listOf(6,0,5,0,0,0,1,0)
        var sampleList1 = mutableListOf<Int>()
        var sampleList2 = mutableListOf<Int>()

        testData.forEach {
            if(it == 0) {
                sampleList1.add(it)
            } else {
                sampleList2.add(it)
            }
        }
        sampleList1.addAll(sampleList2)
        println("Sample list 1 is $sampleList1")
    }

    @Test
    fun `check for palindrome or not`() {
        val testData = "SOS"
        val testData2 = "hfjfdjk"

        val revTestData = testData.reversed()
        Assert.assertEquals(revTestData, testData)

        val revTestData2 = testData2.reversed()
        Assert.assertNotEquals(revTestData2, testData2)

    }

    @Test
    fun `check if given list of elements who sum is equal to 0`() {
        val testData = listOf(3, 4, 5, 0, -2, 1, -4, -6, -9, 6)
        val lastIndex = testData.size
        println("last index $lastIndex")
        var foundTriplate = false
        val uniqueData = mutableSetOf<Int>()

        for (i in 0 until lastIndex - 1) {
            for (j in i + 1 until lastIndex) {
                val x: Int = -(testData[i] + testData[j])
                if (uniqueData.contains(x)) {
                    System.out.printf(
                        "%d %d %d\n", x,
                        testData[i], testData[j]
                    )
                    foundTriplate = true
                } else {
                    uniqueData.add(testData[j])
                }
            }
        }

        if (foundTriplate.not()) {
            System.out.printf(" No Triplet Found\n")
        }

    }

}