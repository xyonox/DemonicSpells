@echo off
setlocal
set CMD_LINE_ARGS=%*
java -classpath "gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %CMD_LINE_ARGS%
