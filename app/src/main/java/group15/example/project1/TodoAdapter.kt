package group15.example.project1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// This adapter inherits from RecyclerView.Adapter
// RecyclerView.Adapter requires 3 function to work.
// onCreateVH, getItemCount, onBindVH
class TodoAdapter(val data: MutableList<TodoModel>) : RecyclerView.Adapter<TodoVH>() {


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoVH {

          // Inflater -> Converts XML file in to readable kotlin class
          val todoView = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)

          return TodoVH(todoView)
     }

     override fun getItemCount(): Int {
          return data.size
     }

     override fun onBindViewHolder(holder: TodoVH, position: Int) {

          holder.todoTitle.text = data[position].title

          holder.viewTodoBtn.setOnClickListener() {


               val intent = Intent(holder.todoItemView.context, MainActivity2::class.java)

               val bundle = Bundle()

               bundle.putString("key", data[position].title)

               intent.putExtras(bundle)

               it.context.startActivity(intent)


          }

     }

     fun addTodo(newTodoItem: TodoModel) {
          // This is like push -> which insert the item at the end
          data.add(newTodoItem)
          // Notifies adapter that we inserted an item
          notifyItemInserted(data.size - 1)
     }

}