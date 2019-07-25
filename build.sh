#!/bin/sh
cd ./com/imagelabeller/backend
javac ./*.java
cd ../../..
javac ./ImageLabeller.java
java ImageLabeller