interface Manager<T> {
    fun addNew(item: T)
    fun listAll(): List<T>
    fun searchById(id: Int): T?
    fun updateStatus(id: Int, isCompleted: Boolean): Boolean
    fun delete(id: Int): Boolean
    fun filter(id: Int, isCompleted: Boolean): List<T>
}

class TaskManager: Manager<Task> {
    private val taskList = mutableListOf<Task>()

    override fun addNew(item: Task) {
        taskList.add(item)
    }

    override fun listAll(): List<Task> {
        return taskList.toList()
    }

    override fun searchById(id: Int): Task? {
        return taskList.find { it.id == id }
    }

    override fun updateStatus(id: Int, isCompleted: Boolean): Boolean {
        val task = taskList.find { it.id == id }
        require(task != null ) { "Tarefa com id $id não existe" }
        task.isCompleted = isCompleted
        return true
    }

    override fun delete(id: Int): Boolean {
        require(taskList.any { it.id == id } ) { "Tarefa com id $id não existe" }
        return taskList.removeIf { it.id == id }
    }

    override fun filter(id: Int, isCompleted: Boolean): List<Task> {
        return taskList.filter { it.isCompleted == isCompleted }
    }
}