@ECHO OFF

:: -------------------------------------------------------

 
SET PROJECT_DIR=%CD%
 


:: chrome, iexplorer, firefox 
 SET BROWSER=chrome
 
 echo --- Testing WHISPER
 SET BASE_URL=http://au.whispir.com
 
 echo --- calling run.bat file...
 
CALL %PROJECT_DIR%\run.bat