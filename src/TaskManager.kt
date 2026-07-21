
sealed class Result() {
    data class Success(val message: String): Result()
    data class Error(val exception: Exception): Result()
}

fun handleResult(result: Result) {
    println(
        when (result) {
            is Result.Error -> "Erro! ${result.exception.message}"
            is Result.Success -> "Success(message=${result.message})"
        }
    )
}

interface Manager<T> {
    fun addNew(item: T): Result
    fun listAll()
    fun searchById(id: Int): T?
    fun updateStatus(id: Int, isCompleted: Boolean): Result
    fun delete(id: Int): Result
    fun filter(isCompleted: Boolean): List<T>
    fun formattedTask(item: T): String
    fun count(): Int
}


class TaskManager: Manager<Task> {
    private val taskList = mutableListOf<Task>()

    override fun addNew(item: Task): Result {
        taskList.add(item)
        return Result.Success("Tarefa adicionada com sucesso! ID: ${item.id}")
    }

    override fun listAll() {
        taskList.toList().forEach { task ->
            val (_, title, _, isCompleted) = task
            println("($title, $isCompleted)")
        }
    }

    override fun formattedTask(item: Task): String {
        return "ID: ${item.id} | Título: ${item.title} | Concluido: ${item.isCompleted} | Criado em: ${item.createdAt} "
    }

    override fun count(): Int = taskList.size

    override fun searchById(id: Int): Task? {
        return taskList.find { it.id == id }
    }

    override fun updateStatus(id: Int, isCompleted: Boolean): Result {
       try {
           val task = taskList.find { it.id == id }
           require(task != null ) {
               "Tarefa com id $id não existe"
           }
           task.isCompleted = isCompleted
           return Result.Success("Status da tarefa ID $id atualizado para $isCompleted")
       } catch (e: IllegalArgumentException) {
           return Result.Error(e)
       }
    }

    override fun delete(id: Int): Result {
        try {
            require(taskList.any { it.id == id } ) {
                "Tarefa com id $id não existe"
            }
            taskList.removeIf { it.id == id }
            return Result.Success("Tarefa com ID $id removida com sucesso")
        } catch (e: IllegalArgumentException) {
            return Result.Error(e)
        }

    }

    override fun filter(isCompleted: Boolean): List<Task> {
        return taskList.filter { it.isCompleted == isCompleted }
    }
}