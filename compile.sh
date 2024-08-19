set -e

javac Point.java
native-image --shared -o libpoint
clang -I ./ -L ./ -l point -Wl,-rpath ./ -o main main.c
