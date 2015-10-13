@ECHO OFF

echo.
 echo --------------------------------------------------------------------------------------
 echo Test Environment: %BROWSER%    %BASE_URL%
 echo --------------------------------------------------------------------------------------
 echo.
 
 echo cd to project directory(%PROJECT_DIR%)...
 CD "%PROJECT_DIR%"
 echo Done
 echo.



 echo Cleaning...
 CALL mvn clean  
 echo Done
 echo.

 echo Compiling...
 CALL mvn compile  
 echo Done
 echo.

 echo Executing...

CALL mvn verify -Dwebdriver.driver=%BROWSER% -Dwebdriver.base.url="%BASE_URL%"



  
 echo Execution Done
 echo.
 CD..

