set projectLocation=D:\$Nutan$\SMC3_Volume\SMC3_Volume
 
cd %projectLocation%
 
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
 
java org.testng.TestNG %projectLocation%\testng.xml
 
