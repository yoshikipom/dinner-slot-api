package com.yoshikipom.dinnerslot.infra.db

import com.yoshikipom.dinnerslot.domain.model.Food
import com.yoshikipom.dinnerslot.domain.service.FoodCreateCommand
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface FoodMapper {

    @Insert("""
        INSERT INTO food (name) VALUES (#{name})
    """)
    fun insert(foodCreateCommand: FoodCreateCommand)

    @Select("""
        SELECT id, name FROM food
    """)
    fun selectAll(): List<Food>

    @Delete("""
        DELETE FROM food WHERE id = #{id}
    """)
    fun delete(id: Long)
}
