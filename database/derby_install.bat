#  derby_install.bat
#  derby
#
#  Created by Михаил on 07.11.17.
#  Copyright © 2017 Михаил. All rights reserved.
current_dir=$PWD
mkdir C:\Apache
copy db-derby-10.14.1.0-bin.zip C:\Apache
cd C:\Apache
unzip db-derby-10.14.1.0-bin.zip
set DERBY_INSTALL=C:\Apache\db-derby-10.14.1.0-bin
set CLASSPATH=%DERBY_INSTALL%\lib\derby.jar;%DERBY_INSTALL%\lib\derbytools.jar;.
set DERBY_HOME=C:\Apache\db-derby-10.14.1.0-bin
set CLASSPATH=%DERBY_HOME%\lib\derby.jar;%DERBY_HOME%\lib\derbytools.jar;.

cd %DERBY_INSTALL%\bin
setEmbeddedCP.bat
cd $current_dir
java -jar $DERBY_HOME\lib\derbyrun.jar ij create_table.sql
