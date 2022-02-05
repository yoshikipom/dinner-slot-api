package com.yoshikipom.dinnerslot.app.controller

import com.yoshikipom.dinnerslot.app.request.FoodCreateRequest
import com.yoshikipom.dinnerslot.domain.model.Food
import com.yoshikipom.dinnerslot.domain.service.FoodCreateCommand
import com.yoshikipom.dinnerslot.domain.service.FoodService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/foods")
class FoodController(private val foodService: FoodService) {

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun post(@RequestBody request: FoodCreateRequest) {
        val foodCreateCommand = FoodCreateCommand(name = request.name!!)
        foodService.save(foodCreateCommand)
    }

    @GetMapping("")
    fun getList(): List<Food> {
        return foodService.findAll()
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: Long) {
        foodService.removeById(id)
    }
}
