package group15.example.project1

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoVH(val todoItemView: View): RecyclerView.ViewHolder(todoItemView) {

    val todoTitle = todoItemView.findViewById<TextView>(R.id.todoItemTitle)
    val viewTodoBtn = todoItemView.findViewById<Button>(R.id.viewTodo)

}