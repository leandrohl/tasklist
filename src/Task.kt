import java.util.Date

data class Task (
    val id: Int = generateId(),
    var title: String,
    var description: String?,
    var isCompleted: Boolean,
    val createdAt: Date) {

    init {
        require(title.isNotBlank()) { "O título da tarefa não pode estar vazio." }
    }

    companion object {
        private var uniqueId: Int = 0

        fun generateId(): Int {
            uniqueId += 1
            return uniqueId
        }
    }
}