package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"sort"
)

func main() {
	// Open the file
	file, err := os.Open(os.Args[1])
	if err != nil {
		log.Fatal(err)
	}
	defer func() { _ = file.Close() }()

	// Read it into a map of words to number of occurence
	wordsMap := make(wordsMap)
	scanner := bufio.NewScanner(file)
	scanner.Split(bufio.ScanWords)
	for scanner.Scan() {
		wordsMap[scanner.Text()]++
	}

	// Turn it into a slice
	words := wordsMap.toSlice()

	// Sort the slice
	sort.Sort(sort.Reverse(words))

	// Print the first 26 (because why not)
	for _, w := range words[:26] {
		fmt.Printf("%s: %d\n", w.word, w.counter)
	}
}

type wordsMap map[string]int

func (w wordsMap) toSlice() words {
	out := make(words, 0, len(w))
	for w, c := range w {
		out = append(out, word{word: w, counter: c})
	}

	return out
}

type word struct {
	word    string
	counter int
}

type words []word

func (w words) Len() int           { return len(w) }
func (w words) Less(i, j int) bool { return w[i].counter < w[j].counter }
func (w words) Swap(i, j int)      { w[i], w[j] = w[j], w[i] }
