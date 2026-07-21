import java.util.Date

data class Task (
    val id: Int = generateId(),
    var title: String,
    var description: String?,
    var isCompleted: Boolean,
    val createdAt: Date) {

    companion object {
        private var uniqueId: Int = 0

        fun generateId(): Int {
            uniqueId += 1
            return uniqueId
        }
    }
}