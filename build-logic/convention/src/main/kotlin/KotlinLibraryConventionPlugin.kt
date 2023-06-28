import com.quran.id.apps.buildutil.applyBoms
import com.quran.id.apps.buildutil.applyKotlinCommon
import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinLibraryConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("kotlin")
      }

      applyKotlinCommon()
      applyBoms()
    }
  }
}
