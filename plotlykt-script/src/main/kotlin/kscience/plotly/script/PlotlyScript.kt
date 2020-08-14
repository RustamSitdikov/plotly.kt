package kscience.plotly.script

import kotlinx.html.FlowContent
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvm.defaultJvmScriptingHostConfiguration
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm

@KotlinScript(
    fileExtension = "plotly.kts",
    compilationConfiguration = PlotlyScriptCompilationConfiguration::class
)
abstract class PlotlyScript


class PlotlyScriptCompilationConfiguration: ScriptCompilationConfiguration({
    baseClass(PlotlyScript::class)
    implicitReceivers(FlowContent::class)
    defaultImports(
        "kotlin.math.*",
        "kscience.plotly.*",
        "kscience.plotly.models.*",
        "hep.dataforge.meta.*",
        "kotlinx.html.*"
    )
    ide {
        acceptedLocations(ScriptAcceptedLocation.Everywhere)
    }
    jvm {
        dependenciesFromCurrentContext(wholeClasspath = true)
    }
    hostConfiguration(defaultJvmScriptingHostConfiguration)
})