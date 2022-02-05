package com.yoshikipom.dinnerslot.infra

import com.yoshikipom.dinnerslot.domain.model.Food
import com.yoshikipom.dinnerslot.domain.repository.FoodRepository
import com.yoshikipom.dinnerslot.domain.service.FoodCreateCommand
import com.yoshikipom.dinnerslot.infra.db.FoodMapper
import org.springframework.stereotype.Repository

@Repository
class FoodRepositoryImpl(private val foodMapper: FoodMapper) : FoodRepository {

    override fun save(foodCreateCommand: FoodCreateCommand) {
        foodMapper.insert(foodCreateCommand)
    }

    override fun findAll(): List<Food> {
        return foodMapper.selectAll()
    }

    override fun removeById(id: Long) {
        foodMapper.delete(id)
    }
}
