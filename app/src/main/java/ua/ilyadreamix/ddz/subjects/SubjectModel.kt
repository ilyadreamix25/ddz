package ua.ilyadreamix.ddz.subjects

data class SubjectModel(
    val name: String,
    val icon: String,
    val bookAuthors: List<Author>
) {
    data class Author(
        val name: String,
        val url: String
    )
}
