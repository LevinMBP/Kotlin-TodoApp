package group15.example.project1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize new TodoAdapter with empty list
        todoAdapter = TodoAdapter(mutableListOf())

        val recyclerView = findViewById<RecyclerView>(R.id.todoItemsRV)
        val todoTitle = findViewById<EditText>(R.id.todoField).text
        val addTodoBtn = findViewById<Button>(R.id.addTodoBtn)

        recyclerView.adapter = todoAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        addTodoBtn.setOnClickListener() {

            if(todoTitle.isNotEmpty()) {
                val newTodo = TodoModel(todoTitle.toString())
                todoAdapter.addTodo(newTodo)
                todoTitle.clear()
            }
        }

    }
}