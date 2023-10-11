package com.vtu.movielist.util

import org.junit.After
import org.junit.Assert
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class HomeWorkTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `check for fib for the number 0`() {
        val n = 0
        val result = HomeWork.fib(n)

        assertEquals(0, result)
    }

    @Test
    fun `check for fib for the number 1`(){
        val n = 1
        val result = HomeWork.fib(n)

        assertEquals(1, result)
    }

    @Test
    fun `check for fib for the negative number -1`() {
        val n = -1
        val result = HomeWork.fib(n)

        assertEquals(1, result)
    }

    @Test
    fun `check fib for large number 34`() {
        val n = 34
        val result = HomeWork.fib(n)

        assertEquals(5702887, result)
    }
}