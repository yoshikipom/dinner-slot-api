package com.yoshikipom.dinnerslot.domain.service

import com.yoshikipom.dinnerslot.domain.model.Food
import com.yoshikipom.dinnerslot.domain.repository.FoodRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

internal class FoodServiceImplTest {

    private lateinit var target: FoodServiceImpl

    private val output = Food(name = "test")

    private val repository = mock<FoodRepository> {
        on { findAll() } doReturn mutableListOf(output)
    }

    @BeforeEach
    internal fun setUp() {
        target = FoodServiceImpl(repository)
    }

    @Test
    fun save() {
        val input = Food(name = "test")

        target.save(input)

        verify(repository).save(input)
    }

    @Test
    fun findAll() {
        val actual = target.findAll()

        assertEquals(1, actual.size)
        assertEquals(output, actual[0])
    }

    @Test
    fun removeById() {
        val id = 123L

        target.removeById(id)

        verify(repository).removeById(id)
    }
}
