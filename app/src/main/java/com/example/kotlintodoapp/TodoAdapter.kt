package com.example.kotlintodoapp

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private  val todos :MutableList<TodoItem>
) :RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()  {

    class  TodoViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val todoTitle: TextView = itemView.findViewById(R.id.tv_todo_text)
        val todoChecked: CheckBox = itemView.findViewById(R.id.cb_checkTodo)
    }

    fun addTodo(todo:TodoItem){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }

    fun delDoneTodos(){
        todos.removeAll{
            todo->  todo.isChecked

        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val view =    LayoutInflater.from(parent.context).inflate(
               R.layout.todo_item,
               parent,
               false
           )

        return  TodoViewHolder(view)
    }
private fun toggleStrikeThrough(tvTodoTitle:TextView, isChecked:Boolean){
if(isChecked){
    tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
}else{
    tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()

}
}
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currEl = todos[position]
  holder.todoTitle.text = currEl.title
        holder.todoChecked.isChecked = currEl.isChecked
        toggleStrikeThrough(holder.todoTitle, currEl.isChecked)
        holder.todoChecked.setOnCheckedChangeListener { _, isChecked ->
    toggleStrikeThrough(holder.todoTitle,isChecked)
            currEl.isChecked = !currEl.isChecked
        }
    }

    override fun getItemCount(): Int {
   return todos.size
    }

}