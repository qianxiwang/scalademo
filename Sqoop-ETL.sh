#!/bin/bash
#mysql emp - > hive  emp_m_to_h - > calculate - > hive result_h_to_m  - > mysql result_a
########
export MYSQL_BASE=/usr/local/mysql
export PATH=$PATH:$MYSQL_BASE/bin
ETL_LOG=/root/data/ETL/etl.log
TODAY=`date`

RUN_STR="
export MYSQL_BASE=/usr/local/mysql
export PATH=$PATH:$MYSQL_BASE/bin
ETL_LOG=/root/data/ETL/etl.log
TODAY=`date`
mysql -uroot -ppassword sqoop -e \"select * from emp\"
hive -e  \"create table if not exists emp_m_to_h (
empno      int ,                                        
ename      string ,                                     
job        string  ,                                    
mgr        int    ,                                     
hiredate   string  ,                                    
sal        double  ,                                    
comm       double  ,                                    
deptno     int) row format delimited fields terminated by '\t';\"  

sqoop import \
--connect jdbc:mysql://hadoop002:3306/sqoop \
--username root --password password \
--table emp \
-m 1 \
--hive-import \
--hive-table emp_m_to_h \
--hive-overwrite \
--delete-target-dir \
--fields-terminated-by '\t' 

hive -e \"create table if not exists result_h_to_m (deptno int,sum_person int) row format delimited fields terminated by '\t';\"
hive -e \"insert overwrite table result_h_to_m select deptno , count(1) as sum_person from emp_m_to_h group by deptno ;\"


mysql -uroot -ppassword sqoop -e \"drop table result_a;\"
mysql -uroot -ppassword sqoop -e \"create table result_a (deptno int,sum_person int);\"

sqoop export \
--connect jdbc:mysql://hadoop002:3306/sqoop \
--username root --password password \
--table result_a \
-m 1 \
--export-dir /user/hive/warehouse/result_h_to_m \
--fields-terminated-by '\t'   

mysql -uroot -ppassword sqoop -e \"select * from result_a;\" > /root/data/ETL/result_a 

" 

echo $TODAY >> $ETL_LOG
/bin/sh -c "$RUN_STR"  >> $ETL_LOG

echo  `date +%Y/%m/%d-%H:%M:%H` === "success"  >> $ETL_LOG
