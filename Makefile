
CC = gcc
CFLAGS = -g -Wall
JAVA = java
JAVAC = javac
CLASSPATH = classes:lib/junit-4.11.jar

all: prep bits java

prep:
	@mkdir -p classes obj bin

java: prep
	find src -type f -iname '*.java' | xargs $(JAVAC) -cp $(CLASSPATH) -d classes -Xlint:unchecked

test: java
	java -cp $(CLASSPATH) test.TestSuite

obj/bits.o: src/bits/bits.c src/bits/bits.h
	$(CC) $(CFLAGS) -c $< -o $@

obj/bittest.o: src/bits/bittest.c
	$(CC) $(CFLAGS) -c $< -o $@

bin/bittest: obj/bits.o obj/bittest.o
	$(CC) $(CFLAGS) $? -o $@

bits: prep bin/bittest

clean:
	rm -rf ./classes ./obj ./bin

.PHONY: all prep java test bits clean
