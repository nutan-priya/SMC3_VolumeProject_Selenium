# Testing Framework for SMC3 Volume LTL(Ubuntu)

## System Requirements
- Jenkins
- Google Chrome for Ubuntu
- Google Chrome Driver for Ubuntu
- xvbf Jenkins plugin

# Installation
1. Add freelstyle pipeline in Jenkins
2. Add source code in Advanced > Use custom workspace
3. In build section. add build step as Execute Shell >
 ```
cd /home/administrator/Desktop/Projects/SMC3_VolumeProject_Selenium/
sh execute.sh
```
4. Apply and Save.
5. Go to Manage Jenkins > Configure Jenkins > Shell
```
/bin/sh
```
7. For xvfb and Chrome driver installation > https://christopher.su/2015/selenium-chromedriver-ubuntu/

8. Run command on root folder
```
chmod +x execute.sh ExternalFiles/chromediver
chmod 777 test-outout/ -Rf
```
