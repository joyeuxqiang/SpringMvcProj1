@echo off
::portΪ��Ҫȥ�󶨶˿�
set port=8080
for /f "tokens=5 delims= " %%a in ('netstat -ano ^|findstr /c "%port%"') do ( 
echo pid=%%a
taskkill /f /pid %%a
GOTO :OUTFOR
)
:OUTFOR
pause