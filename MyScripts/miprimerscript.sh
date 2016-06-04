#! /bin/bash
separador="======================================================================"
os=`sudo cat /etc/issue`
kernel=`uname -sr`
CPU=`sudo lshw -C CPU | grep  width`
NETWORK=`/sbin/ifconfig | grep -i addr | grep -i bcast`
PUBLICIP=`GET http://www.vermiip.es/  | grep "Tu IP p&uacute;blica es" | cut -d ':' -f2 | cut -d '<' -f1`
USERS=`who`
SERVICES=`sudo nmap -sT -O localhost`

echo $separador
echo OS Version 
echo $os

echo $separador
echo Kernel Version
echo $kernel

echo $separador
echo computer architecture 
echo $CPU

echo $separador
echo hostname
echo `hostname`

echo $separador
echo network info
echo $NETWORK

echo $separador
echo public ip 
echo $PUBLICIP

echo $separador
echo DNS Server
echo `cat /etc/resolv.conf | grep "nameserver"`

echo $separador
echo Servicios en uso y sus puertos
echo $SERVICES

echo $separador
echo Usuarios logeados
echo $USERS

echo $separador
echo Memoria libe RAM, SWAP, CACHE
echo `free`

echo $separador
echo Uso de disco
echo `df -h`

echo $separador
echo Tiempo de uso de la maquina
echo `uptime`

