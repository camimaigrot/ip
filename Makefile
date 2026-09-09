SRC = src/main/java
BIN = bin
MAIN = ace.Ace

SOURCES = $(shell find $(SRC) -name "*.java")

.PHONY: all compile run clean

all: run

compile:
	mkdir -p $(BIN)
	javac -d $(BIN) $(SOURCES)

run: compile
	java -cp $(BIN) $(MAIN)

clean:
	rm -rf $(BIN)
