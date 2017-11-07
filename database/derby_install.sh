#!/bin/sh

#  derby_install.sh
#  derby
#
#  Created by Михаил on 07.11.17.
#  Copyright © 2017 Михаил. All rights reserved.
current_dir=$PWD;
mkdir /opt/Apache;
cp db-derby-10.14.1.0-bin.tar.gz /opt/Apache;
cd /opt/Apache;
tar xzvf db-derby-10.14.1.0-bin.tar.gz;
export DERBY_INSTALL=/opt/Apache/db-derby-10.14.1.0-bin;
export CLASSPATH=$DERBY_INSTALL/lib/derby.jar:$DERBY_INSTALL/lib/derbytools.jar:.;
export DERBY_HOME=/opt/Apache/db-derby-10.14.1.0-bin;
export CLASSPATH=$DERBY_HOME/derby.jar:$DERBY_HOME/derbytools.jar:.;
cd $DERBY_INSTALL/bin;
. setEmbeddedCP;
cd $current_dir;
java -jar $DERBY_HOME/lib/derbyrun.jar ij create_table.sql;
