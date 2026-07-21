//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val taskManager: TaskManager = TaskManager()

    handleResult(taskManager.addNew(item = Task(title = "Comprar pão", isCompleted = false)))
    handleResult(taskManager.addNew(item = Task(title = "Estudar Kotlin", isCompleted = false)))
    handleResult(taskManager.addNew(item = Task(title = "Fazer exercicios", isCompleted = false)))

    println("\nTarefas")
    taskManager.listAll()

    handleResult(taskManager.updateStatus(1, true))

    println("\nTarefas concluídas")
    val completedTasks: List<Task> = taskManager.filter(isCompleted = true)
    for (task in completedTasks) {
        println(taskManager.formattedTask(item = task))
    }

    handleResult(taskManager.delete(2))

    println("\nTotal de tarefas: ${taskManager.count()}")

}