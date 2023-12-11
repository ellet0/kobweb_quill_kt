
import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    // alias(libs.plugins.kobwebx.markdown)
}

group = "net.freshplatform.kobweb_quill_kt"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            head.add {
                val quillVersion = libs.versions.quill.get()
                link(href = "https://cdn.quilljs.com/${quillVersion}/quill.snow.css", rel = "stylesheet")
                script {
                    src = "https://cdn.quilljs.com/${quillVersion}/quill.js"
                }
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("app", includeServer = false)
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk)
                implementation(project(":kobweb_quill_kt"))
            }
        }
    }
}
