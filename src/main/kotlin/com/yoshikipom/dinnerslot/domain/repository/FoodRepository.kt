package com.yoshikipom.dinnerslot.domain.repository

import com.yoshikipom.dinnerslot.domain.model.Food
import com.yoshikipom.dinnerslot.domain.service.FoodCreateCommand

interface FoodRepository {
    fun save(foodCreateCommand: FoodCreateCommand)
    fun findAll(): List<Food>
    fun removeById(id: Long)
}
