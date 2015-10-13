@ECHO OFF

echo.
 echo --------------------------------------------------------------------------------------
 echo Test Environment: %BRAND% : %PLATFORM% %LAN%    %BASE_URL%
 echo --------------------------------------------------------------------------------------
 echo.

 echo Removing previous test results...
 IF exist %PROJECT_DIR%\%TEST_RESULTS%\%BRAND%_%PLATFORM%_%LAN%_%TEST_RESULTS%  DEL /S /Q /F %PROJECT_DIR%\%TEST_RESULTS%\%BRAND%_%PLATFORM%_%LAN%_%TEST_RESULTS% | echo > NUL
 echo Done
 echo.
 
 echo cd to project directory(%PROJECT_DIR%)...
 CD "%PROJECT_DIR%"
 echo Done
 echo.

SET DEFAULTPROFILE=%SINGLETHREAD%

 IF %PROFILE%==%MULTITHREAD% (SET DEFAULTPROFILE=%MULTITHREAD%) ELSE (
  IF %PROFILE%==%SINGLETHREAD% (SET DEFAULTPROFILE=%SINGLETHREAD%) ELSE (
   IF %PROFILE%==%PARALLEL% (SET DEFAULTPROFILE=%PARALLEL%) ELSE (
    echo ****************** Invalid profile configuration... 
    echo ****************** Using default profile: "%DEFAULTPROFILE%"
   )
  )
 )

 echo --- Running in %DEFAULTPROFILE% mode ---


 echo --- Deleting table files from %DESTINATION%... 
 IF EXIST %DESTINATION%\*.table DEL /Q /F %DESTINATION%\*.table
 echo Done 
 echo.
 
 echo Preparing test-data files...
REM copy test_data to appropriate files
 COPY /Y "%SOURCE%\%LAN%_General.table" "%DESTINATION%\General.table"
 echo Done
 echo.
REM )

 echo Cleaning...
 CALL mvn clean  
 echo Done
 echo.

 echo Compiling...
 CALL mvn compile  
 echo Done
 echo.

 echo Executing...
REM the metafilter=-skip is configured in Serenity.properties file, so no need to pass it as a parameter
REM	CALL mvn verify -Dmetafilter="-skip" | echo >> log.txt
REM to run with checkstyle and OMD use -DskipTests. To disable code compliance use -DskipCodeCompliance=true 
REM CALL mvn verify -DskipTests -Dwebdriver.driver=%BROWSER% -Dwebdriver.base.url="%BASE_URL%"
REM CALL mvn verify -Dmetafilter=%META_FILTER%  -Dwebdriver.driver=%BROWSER% -Dwebdriver.base.url="%BASE_URL%" -Dbrand="%BRAND%"

 
 IF %PROFILE%==%MULTITHREAD% ( 
 echo Starting in myversion
CALL mvn integration-test -P %DEFAULTPROFILE% -Dlan=%LAN% -Dbrand=%BRAND% -Dmetafilter=%META_FILTER%  -Dwebdriver.driver=%BROWSER% -Dwebdriver.base.url="%BASE_URL%" -Dplatform=%PLATFORM%
CALL mvn serenity:aggregate -P %DEFAULTPROFILE%
 )
 
IF %PROFILE%==%SINGLETHREAD% ( 
echo SINGLETHREAD
REM CALL mvn verify -Dmetafilter=%META_FILTER%  -Dwebdriver.driver=%BROWSER% -Dwebdriver.base.url="%BASE_URL%" -Dbrand.name="%BRAND%"
IF %PLATFORM%==BROWSERSTACK (
CALL mvn verify -P %DEFAULTPROFILE% -DproxySet=true -DproxyHost=proxy4.wipro.com -DproxyPort=8080 -DproxyUser=PA257736 -DproxyPass=HashTag26 -Dlan=%LAN% -Dbrand=%BRAND% -Dmetafilter=%META_FILTER% -Dplatform=%PLATFORM% -Dbrowserstack.os=%BROWSERSTACK_OS% -Dbrowserstack.os.version=%BROWSERSTACK_OS_VERSION% -Dbrowserstack.browser=%BROWSER% -Dbrowserstack.browser.version=%BROWSER_VERSION% -Dbrowserstack.build=BROWSERSTACK_BUILD -Dbrowserstack.url="%BROWSERSTACK_URL%" -Dwebdriver.base.url="%BASE_URL%"
) ELSE (
CALL mvn verify -P %DEFAULTPROFILE% -Dlan=%LAN% -Dbrand=%BRAND% -Dmetafilter=%META_FILTER%  -Dwebdriver.driver=%BROWSER% -Dwebdriver.base.url="%BASE_URL%" -Dplatform=%PLATFORM% -DadobeAemAuthorUrl="%ADOBE_AEM_AUTHOR_URL%" -DadobeSiteAdminUrl="%ADOBE_SITE_ADMIN_URL%"
)
)

  
 echo Execution Done
 echo.


 echo --- Copying test result to %TEST_RESULTS% folder... 
IF NOT EXIST %PROJECT_DIR%\%TEST_RESULTS% MD %PROJECT_DIR%\%TEST_RESULTS%
XCOPY /E "%PROJECT_DIR%\target\*.*" "%PROJECT_DIR%\%TEST_RESULTS%\%BRAND%_%PLATFORM%_%LAN%_%TEST_RESULTS%\*.*"  | echo > NUL
 echo Done
 echo.
 
 CD..

