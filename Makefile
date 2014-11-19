
CC = gcc
JAVA = java
JAVAC = javac
CLASSPATH = src:classes:lib/junit-4.11.jar

all: prep bits java

prep:
	@mkdir -p classes obj bin

java: prep
	find src -type f -iname '*.java' | xargs $(JAVAC) -cp $(CLASSPATH) -d classes -Xlint:unchecked

test: java
	java -cp classes:lib/junit-4.11.jar test.TestSuite

obj/bits.o: src/bits/bits.c src/bits/bits.h obj
	$(CC) -c $< -o obj/bits.o

obj/bittest.o: src/bits/bittest.c obj
	$(CC) -c $< -o obj/bittest.o

bin/bittest: obj/bits.o obj/bittest.o
	$(CC) obj/bits.o obj/bittest.o -o bin/bittest

bits: prep bin/bittest

clean:
	rm -rf ./classes ./obj ./bin

.PHONY: all prep java test bits clean
