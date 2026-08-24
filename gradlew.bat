@echo off
REM Gradle wrapper - minimal
set DIRNAME=%~dp0
if defined JAVA_HOME (
  "%JAVA_HOME%\bin\java" -jar "%DIRNAME%gradle\wrapper\gradle-wrapper.jar" %*
) else (
  java -jar "%DIRNAME%gradle\wrapper\gradle-wrapper.jar" %*
)
