
CC = gcc
JAVA = java
JAVAC = javac
CLASSPATH = classes:lib/junit-4.11.jar

all: prep classes/list/LinkedList.class classes/list/LinkedListTest.class \
	classes/dict/Hashtable.class \
	classes/dict/HashtableTest.class bits

prep: classes obj bin

classes:
	mkdir classes

obj:
	mkdir obj

bin:
	mkdir bin

classes/list/LinkedList.class: src/list/LinkedList.java classes
	$(JAVAC) -g -Xlint:unchecked -cp $(CLASSPATH) -d classes $<

classes/list/LinkedListTest.class: src/list/LinkedListTest.java classes/list/LinkedList.class
	$(JAVAC) -g -Xlint:unchecked -cp $(CLASSPATH) -d classes $<

classes/dict/Hashtable.class: src/dict/Hashtable.java classes
	$(JAVAC) -g -Xlint:unchecked -cp $(CLASSPATH) -d classes $<

classes/dict/HashtableTest.class: src/dict/HashtableTest.java classes/dict/Hashtable.class
	$(JAVAC) -g -Xlint:unchecked -cp $(CLASSPATH) -d classes $<

linktest: classes/list/LinkedListTest.class
	$(JAVA) -cp $(CLASSPATH) org.junit.runner.JUnitCore list.LinkedListTest

hashtest: classes/dict/HashtableTest.class
	$(JAVA) -cp $(CLASSPATH) org.junit.runner.JUnitCore dict.HashtableTest

obj/bits.o: src/bits/bits.c src/bits/bits.h obj
	$(CC) -c $< -o obj/bits.o

obj/bittest.o: src/bits/bittest.c obj
	$(CC) -c $< -o obj/bittest.o

bin/bittest: obj/bits.o obj/bittest.o
	$(CC) obj/bits.o obj/bittest.o -o bin/bittest

bits: prep bin/bittest

clean:
	rm -rf ./classes ./obj ./bin

.PHONY: all test clean
