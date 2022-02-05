package com.yoshikipom.dinnerslot.domain.service

import com.yoshikipom.dinnerslot.domain.model.Food

interface FoodService {
    fun save(foodCreateCommand: FoodCreateCommand)
    fun findAll(): List<Food>
    fun removeById(id: Long)
}
