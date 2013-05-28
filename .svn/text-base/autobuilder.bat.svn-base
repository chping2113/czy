@echo off
cls

echo 启动KJLINK WEB项目自动化构建系统
echo 开始自动化编译项目ACHOERP...

rem set current direcotry for work home
set CURRENT_DIR=%cd%

rem execute ant task
echo 调用ANT开始自动构建项目...
cd %CURRENT_DIR%
call ant checkout
call ant compile
call ant startup

cd %CURRENT_DIR%
exit
:end