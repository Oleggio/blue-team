@REM play-scala-server launcher script
@REM
@REM Environment:
@REM JAVA_HOME - location of a JDK home dir (optional if java on path)
@REM CFG_OPTS  - JVM options (optional)
@REM Configuration:
@REM PLAY_SCALA_SERVER_config.txt found in the PLAY_SCALA_SERVER_HOME.
@setlocal enabledelayedexpansion

@echo off

if "%PLAY_SCALA_SERVER_HOME%"=="" set "PLAY_SCALA_SERVER_HOME=%~dp0\\.."

set "APP_LIB_DIR=%PLAY_SCALA_SERVER_HOME%\lib\"

rem Detect if we were double clicked, although theoretically A user could
rem manually run cmd /c
for %%x in (!cmdcmdline!) do if %%~x==/c set DOUBLECLICKED=1

rem FIRST we load the config file of extra options.
set "CFG_FILE=%PLAY_SCALA_SERVER_HOME%\PLAY_SCALA_SERVER_config.txt"
set CFG_OPTS=
if exist "%CFG_FILE%" (
  FOR /F "tokens=* eol=# usebackq delims=" %%i IN ("%CFG_FILE%") DO (
    set DO_NOT_REUSE_ME=%%i
    rem ZOMG (Part #2) WE use !! here to delay the expansion of
    rem CFG_OPTS, otherwise it remains "" for this loop.
    set CFG_OPTS=!CFG_OPTS! !DO_NOT_REUSE_ME!
  )
)

rem We use the value of the JAVACMD environment variable if defined
set _JAVACMD=%JAVACMD%

if "%_JAVACMD%"=="" (
  if not "%JAVA_HOME%"=="" (
    if exist "%JAVA_HOME%\bin\java.exe" set "_JAVACMD=%JAVA_HOME%\bin\java.exe"
  )
)

if "%_JAVACMD%"=="" set _JAVACMD=java

rem Detect if this java is ok to use.
for /F %%j in ('"%_JAVACMD%" -version  2^>^&1') do (
  if %%~j==java set JAVAINSTALLED=1
  if %%~j==openjdk set JAVAINSTALLED=1
)

rem BAT has no logical or, so we do it OLD SCHOOL! Oppan Redmond Style
set JAVAOK=true
if not defined JAVAINSTALLED set JAVAOK=false

if "%JAVAOK%"=="false" (
  echo.
  echo A Java JDK is not installed or can't be found.
  if not "%JAVA_HOME%"=="" (
    echo JAVA_HOME = "%JAVA_HOME%"
  )
  echo.
  echo Please go to
  echo   http://www.oracle.com/technetwork/java/javase/downloads/index.html
  echo and download a valid Java JDK and install before running play-scala-server.
  echo.
  echo If you think this message is in error, please check
  echo your environment variables to see if "java.exe" and "javac.exe" are
  echo available via JAVA_HOME or PATH.
  echo.
  if defined DOUBLECLICKED pause
  exit /B 1
)


rem We use the value of the JAVA_OPTS environment variable if defined, rather than the config.
set _JAVA_OPTS=%JAVA_OPTS%
if "!_JAVA_OPTS!"=="" set _JAVA_OPTS=!CFG_OPTS!

rem We keep in _JAVA_PARAMS all -J-prefixed and -D-prefixed arguments
rem "-J" is stripped, "-D" is left as is, and everything is appended to JAVA_OPTS
set _JAVA_PARAMS=
set _APP_ARGS=

:param_loop
call set _PARAM1=%%1
set "_TEST_PARAM=%~1"

if ["!_PARAM1!"]==[""] goto param_afterloop


rem ignore arguments that do not start with '-'
if "%_TEST_PARAM:~0,1%"=="-" goto param_java_check
set _APP_ARGS=!_APP_ARGS! !_PARAM1!
shift
goto param_loop

:param_java_check
if "!_TEST_PARAM:~0,2!"=="-J" (
  rem strip -J prefix
  set _JAVA_PARAMS=!_JAVA_PARAMS! !_TEST_PARAM:~2!
  shift
  goto param_loop
)

if "!_TEST_PARAM:~0,2!"=="-D" (
  rem test if this was double-quoted property "-Dprop=42"
  for /F "delims== tokens=1,*" %%G in ("!_TEST_PARAM!") DO (
    if not ["%%H"] == [""] (
      set _JAVA_PARAMS=!_JAVA_PARAMS! !_PARAM1!
    ) else if [%2] neq [] (
      rem it was a normal property: -Dprop=42 or -Drop="42"
      call set _PARAM1=%%1=%%2
      set _JAVA_PARAMS=!_JAVA_PARAMS! !_PARAM1!
      shift
    )
  )
) else (
  if "!_TEST_PARAM!"=="-main" (
    call set CUSTOM_MAIN_CLASS=%%2
    shift
  ) else (
    set _APP_ARGS=!_APP_ARGS! !_PARAM1!
  )
)
shift
goto param_loop
:param_afterloop

set _JAVA_OPTS=!_JAVA_OPTS! !_JAVA_PARAMS!
:run

set "APP_CLASSPATH=%APP_LIB_DIR%\..\conf\;%APP_LIB_DIR%\play-scala-server.play-scala-server-1.0-SNAPSHOT-sans-externalized.jar;%APP_LIB_DIR%\shared.shared-1.0-SNAPSHOT.jar;%APP_LIB_DIR%\org.apache.commons.commons-lang3-3.6.jar;%APP_LIB_DIR%\com.vmunier.scalajs-scripts_2.12-1.1.0.jar;%APP_LIB_DIR%\com.google.inject.extensions.guice-assistedinject-4.1.0.jar;%APP_LIB_DIR%\com.lihaoyi.sourcecode_2.12-0.1.3.jar;%APP_LIB_DIR%\com.google.guava.guava-22.0.jar;%APP_LIB_DIR%\com.typesafe.akka.akka-slf4j_2.12-2.5.3.jar;%APP_LIB_DIR%\org.apache.commons.commons-compress-1.9.jar;%APP_LIB_DIR%\com.lihaoyi.autowire_2.12-0.2.6.jar;%APP_LIB_DIR%\org.scala-lang.scala-library-2.12.2.jar;%APP_LIB_DIR%\com.typesafe.play.play-json_2.12-2.6.3.jar;%APP_LIB_DIR%\com.typesafe.play.play-ws-standalone-xml_2.12-1.0.0.jar;%APP_LIB_DIR%\com.typesafe.akka.akka-stream_2.12-2.5.3.jar;%APP_LIB_DIR%\com.typesafe.ssl-config-core_2.12-0.2.2.jar;%APP_LIB_DIR%\org.webjars.webjars-locator-0.32.jar;%APP_LIB_DIR%\com.typesafe.play.play-ahc-ws-standalone_2.12-1.0.0.jar;%APP_LIB_DIR%\com.typesafe.config-1.3.1.jar;%APP_LIB_DIR%\com.typesafe.play.play-functional_2.12-2.6.3.jar;%APP_LIB_DIR%\io.jsonwebtoken.jjwt-0.7.0.jar;%APP_LIB_DIR%\com.google.inject.guice-4.1.0.jar;%APP_LIB_DIR%\org.webjars.jquery-1.11.1.jar;%APP_LIB_DIR%\com.google.j2objc.j2objc-annotations-1.1.jar;%APP_LIB_DIR%\org.slf4j.jul-to-slf4j-1.7.25.jar;%APP_LIB_DIR%\commons-codec.commons-codec-1.10.jar;%APP_LIB_DIR%\org.webjars.webjars-locator-core-0.30.jar;%APP_LIB_DIR%\com.fasterxml.jackson.core.jackson-databind-2.8.9.jar;%APP_LIB_DIR%\ch.qos.logback.logback-classic-1.2.3.jar;%APP_LIB_DIR%\org.webjars.bootstrap-3.3.7.jar;%APP_LIB_DIR%\com.typesafe.play.play-server_2.12-2.6.0.jar;%APP_LIB_DIR%\com.google.errorprone.error_prone_annotations-2.0.18.jar;%APP_LIB_DIR%\com.typesafe.play.play-ws_2.12-2.6.0.jar;%APP_LIB_DIR%\com.typesafe.play.play-netty-utils-2.6.0.jar;%APP_LIB_DIR%\com.typesafe.akka.akka-actor_2.12-2.5.3.jar;%APP_LIB_DIR%\com.fasterxml.jackson.datatype.jackson-datatype-jdk8-2.8.9.jar;%APP_LIB_DIR%\org.scala-lang.modules.scala-java8-compat_2.12-0.8.0.jar;%APP_LIB_DIR%\org.spire-math.jawn-parser_2.12-0.10.3.jar;%APP_LIB_DIR%\org.reactivestreams.reactive-streams-1.0.0.jar;%APP_LIB_DIR%\javax.cache.cache-api-1.0.0.jar;%APP_LIB_DIR%\aopalliance.aopalliance-1.0.jar;%APP_LIB_DIR%\com.lihaoyi.scalatags_2.12-0.6.3.jar;%APP_LIB_DIR%\com.lihaoyi.derive_2.12-0.4.4.jar;%APP_LIB_DIR%\com.typesafe.play.play-logback_2.12-2.6.0.jar;%APP_LIB_DIR%\com.typesafe.play.play-streams_2.12-2.6.0.jar;%APP_LIB_DIR%\org.scala-lang.scala-reflect-2.12.2.jar;%APP_LIB_DIR%\com.typesafe.play.shaded-asynchttpclient-1.0.0.jar;%APP_LIB_DIR%\com.typesafe.akka.akka-http-core_2.12-10.0.8.jar;%APP_LIB_DIR%\com.typesafe.play.twirl-api_2.12-1.3.2.jar;%APP_LIB_DIR%\com.fasterxml.jackson.core.jackson-core-2.8.9.jar;%APP_LIB_DIR%\org.webjars.webjars-play_2.12-2.6.0-M1.jar;%APP_LIB_DIR%\com.typesafe.play.build-link-2.6.0.jar;%APP_LIB_DIR%\org.scala-lang.modules.scala-xml_2.12-1.0.6.jar;%APP_LIB_DIR%\joda-time.joda-time-2.9.9.jar;%APP_LIB_DIR%\com.typesafe.akka.akka-parsing_2.12-10.0.8.jar;%APP_LIB_DIR%\com.fasterxml.jackson.datatype.jackson-datatype-jsr310-2.8.9.jar;%APP_LIB_DIR%\org.codehaus.mojo.animal-sniffer-annotations-1.14.jar;%APP_LIB_DIR%\org.webjars.requirejs-2.1.20.jar;%APP_LIB_DIR%\org.slf4j.jcl-over-slf4j-1.7.25.jar;%APP_LIB_DIR%\com.fasterxml.jackson.core.jackson-annotations-2.8.9.jar;%APP_LIB_DIR%\com.google.code.findbugs.jsr305-3.0.2.jar;%APP_LIB_DIR%\com.typesafe.play.play_2.12-2.6.0.jar;%APP_LIB_DIR%\com.typesafe.play.filters-helpers_2.12-2.6.0.jar;%APP_LIB_DIR%\org.scala-lang.modules.scala-parser-combinators_2.12-1.0.6.jar;%APP_LIB_DIR%\com.lihaoyi.upickle_2.12-0.4.4.jar;%APP_LIB_DIR%\javax.transaction.jta-1.1.jar;%APP_LIB_DIR%\javax.inject.javax.inject-1.jar;%APP_LIB_DIR%\org.slf4j.slf4j-api-1.7.25.jar;%APP_LIB_DIR%\org.typelevel.macro-compat_2.12-1.1.1.jar;%APP_LIB_DIR%\com.typesafe.play.play-ws-standalone_2.12-1.0.0.jar;%APP_LIB_DIR%\com.typesafe.play.shaded-oauth-1.0.0.jar;%APP_LIB_DIR%\ch.qos.logback.logback-core-1.2.3.jar;%APP_LIB_DIR%\com.typesafe.play.play-akka-http-server_2.12-2.6.0.jar;%APP_LIB_DIR%\com.typesafe.play.play-ahc-ws_2.12-2.6.0.jar;%APP_LIB_DIR%\com.typesafe.play.play-ws-standalone-json_2.12-1.0.0.jar;%APP_LIB_DIR%\com.typesafe.play.play-guice_2.12-2.6.0.jar;%APP_LIB_DIR%\com.typesafe.play.play-exceptions-2.6.0.jar;%APP_LIB_DIR%\org.webjars.animate.css-3.5.2.jar;%APP_LIB_DIR%\org.joda.joda-convert-1.7.jar;%APP_LIB_DIR%\com.typesafe.play.cachecontrol_2.12-1.1.2.jar;%APP_LIB_DIR%\play-scala-server.play-scala-server-1.0-SNAPSHOT-assets.jar"
set "APP_MAIN_CLASS=play.core.server.ProdServerStart"

if defined CUSTOM_MAIN_CLASS (
    set MAIN_CLASS=!CUSTOM_MAIN_CLASS!
) else (
    set MAIN_CLASS=!APP_MAIN_CLASS!
)

rem Call the application and pass all arguments unchanged.
"%_JAVACMD%" !_JAVA_OPTS! !PLAY_SCALA_SERVER_OPTS! -cp "%APP_CLASSPATH%" %MAIN_CLASS% !_APP_ARGS!

@endlocal


:end

exit /B %ERRORLEVEL%
