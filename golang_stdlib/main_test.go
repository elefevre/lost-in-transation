package main

import (
	"reflect"
	"sort"
	"testing"
)

func Test_wordsMap_toSlice(t *testing.T) {
	m := wordsMap{
		"foo": 1,
		"bar": 2,
		"baz": 3,
	}

	s := m.toSlice()
	expected := words{
		{
			word:    "foo",
			counter: 1,
		},
		{
			word:    "bar",
			counter: 2,
		},
		{
			word:    "baz",
			counter: 3,
		},
	}

	if !reflect.DeepEqual(s, expected) {
		t.Errorf("wordsMap.toSlice() = %v, want %v", s, expected)
	}
}

func Test_words_sort(t *testing.T) {
	w := words{
		{
			word:    "foo",
			counter: 1,
		},
		{
			word:    "bar",
			counter: 2,
		},
		{
			word:    "baz",
			counter: 3,
		},
	}

	sort.Sort(sort.Reverse(w))

	expected := words{
		{
			word:    "baz",
			counter: 3,
		},
		{
			word:    "bar",
			counter: 2,
		},
		{
			word:    "foo",
			counter: 1,
		},
	}

	if !reflect.DeepEqual(expected, w) {
		t.Errorf("sort.Sort() = %v, want %v", w, expected)
	}
}
