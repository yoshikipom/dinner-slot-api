package com.yoshikipom.dinnerslot.domain.service

import com.yoshikipom.dinnerslot.domain.model.Food
import com.yoshikipom.dinnerslot.domain.repository.FoodRepository
import org.springframework.stereotype.Service

@Service
class FoodServiceImpl(private val foodRepository: FoodRepository) : FoodService {

    override fun save(foodCreateCommand: FoodCreateCommand) {
        foodRepository.save(foodCreateCommand)
    }

    override fun findAll(): List<Food> {
        return foodRepository.findAll()
    }


    override fun removeById(id: Long) {
        return foodRepository.removeById(id)
    }
}
