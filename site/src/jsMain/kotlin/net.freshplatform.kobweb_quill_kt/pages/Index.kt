package net.freshplatform.kobweb_quill_kt.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.dom.Div

@Composable
@Page
fun HomePage() {
    Div(
        attrs = Modifier.id("editor").toAttrs()
    )
    LaunchedEffect(Unit) {
//        """
//            var quill = new Quill('#editor', {
//                theme: 'snow',
//                modules: {
//                    toolbar: true
//                }
//            });
//        """.trimIndent()
        js("var quill = new Quill('#editor', {\n" +
                "                theme: 'snow',\n" +
                "                modules: {\n" +
                "                    toolbar: true\n" +
                "                }\n" +
                "            });") as Unit
    }
}