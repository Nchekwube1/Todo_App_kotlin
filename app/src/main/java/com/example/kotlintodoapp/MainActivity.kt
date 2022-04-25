package com.example.kotlintodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private  lateinit var todoAdapter:TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      val recyclerView = findViewById<RecyclerView>(R.id.rvTodoItems)
        todoAdapter = TodoAdapter(mutableListOf())
        recyclerView.adapter = todoAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val addTodo = findViewById<Button>(R.id.add_todo_btn)
        val delTodo = findViewById<Button>(R.id.del_comp_btn)
        val inputVal = findViewById<EditText>(R.id.et_add_todo)
        addTodo.setOnClickListener{
            val newTodo = inputVal.text.toString()
            if(newTodo.isNotEmpty()){
                val todoItem = TodoItem(newTodo)
                todoAdapter.addTodo(todoItem)
                inputVal.text.clear()
            }
        }
        }
    }
