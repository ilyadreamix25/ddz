package ua.ilyadreamix.ddz.subjects

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.skrape.core.htmlDocument
import it.skrape.selects.html5.a
import it.skrape.selects.html5.div
import it.skrape.selects.html5.span
import it.skrape.selects.html5.table
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ua.ilyadreamix.ddz.etc.VSHKOLE_URL
import java.net.URL

class SubjectsViewModel : ViewModel() {
    private var _subjects: MutableState<List<SubjectModel>> = mutableStateOf(emptyList())
    val subjects: State<List<SubjectModel>> = _subjects

    fun updateSubjects(grade: Int) = viewModelScope.launch {
        _subjects.value = fetch(grade)
    }

    // TODO: Errors handling
    private suspend fun fetch(grade: Int) = withContext(Dispatchers.IO) {
        htmlDocument(URL("$VSHKOLE_URL/$grade-klass/reshebniki").readText()) {
            div {
                withClass = "book-box"
                findAll {
                    val filtered = this.filter { element ->
                        val classes = element.classNames
                        classes.size >= 2 && !classes.contains("box-only-mobile")
                    }

                    filtered.map { bookBox ->
                        SubjectModel(
                            name = bookBox.table {
                                withClass = "subject"
                                findFirst { this.text }
                            },
                            icon = "no-icon",
                            bookAuthors = bookBox.div {
                                withClass = "author-wrap"
                                a {
                                    findAll {
                                        map { element ->
                                            SubjectModel.Author(
                                                name = element.span {
                                                    findFirst { this.text }
                                                },
                                                url = element.eachHref.first()
                                            )
                                        }
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
