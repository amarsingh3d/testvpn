#!/bin/sh

netstat -vanp tcp | grep 45691

lsof -t -i tcp:45691 | xargs kill