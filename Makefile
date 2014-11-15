
JAVA = java
JAVAC = javac
CLASSPATH = classes:lib/junit-4.11.jar

all: classes classes/list/LinkedList.class classes/list/LinkedListTest.class

classes:
	mkdir classes

classes/list/LinkedList.class: src/list/LinkedList.java classes
	$(JAVAC) -Xlint:unchecked -cp $(CLASSPATH) -d classes $<

classes/list/LinkedListTest.class: src/list/LinkedListTest.java classes/list/LinkedList.class
	$(JAVAC) -Xlint:unchecked -cp $(CLASSPATH) -d classes $<

test: classes/list/LinkedListTest.class
	$(JAVA) -cp $(CLASSPATH) org.junit.runner.JUnitCore list.LinkedListTest

clean:
	rm -rf ./classes

.PHONY: all test clean
