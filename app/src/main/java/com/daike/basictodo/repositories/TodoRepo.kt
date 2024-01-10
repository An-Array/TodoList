package com.daike.basictodo.repositories

import com.daike.basictodo.database.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepo {
    suspend fun getTodos(): Flow<List<TodoEntity>>
    suspend fun addTodo(todo:TodoEntity)
    suspend fun updateTodo(todo: TodoEntity)
    suspend fun deleteTodo(todo: TodoEntity)
}