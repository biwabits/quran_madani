import com.android.build.gradle.LibraryExtension
import com.quran.id.apps.buildutil.applyAndroidCommon
import com.quran.id.apps.buildutil.applyBoms
import com.quran.id.apps.buildutil.applyKotlinCommon
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
      }

      extensions.configure<LibraryExtension> {
        applyAndroidCommon()
        defaultConfig.targetSdk = 32
      }

      applyKotlinCommon()
      applyBoms()
    }
  }
}
