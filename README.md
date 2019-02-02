Lost in Translation
===================

The project
-----------
The objective is to explore various programming styles.

The idea is to invite contributors to implement the same programming task in various ways, in many different programming languages. Those programs will all be translations of one another.

I am hoping there will be several implementations in the same language. Hopefully, different implementors with different backgrounds will provide differing implementations in the same language, even with the same initial intentions.

The why
-------
Inspiration came from [Le Ton beau de Marot: In Praise of the Music of Language](https://en.wikipedia.org/wiki/Le_Ton_beau_de_Marot), a book where Douglas Hofstadter compares various translations of a short French poem. There are many possible translations and Hofstadter himself comes with several of them.

Each translation of the poem has its own flavor. Some are more faithful than others. Some take liberties in the content to be closer to the spirit of the original poem.

I was wondering if the same effect might be seen when re-coding a task into other programming languages, or even in the same languages. This project is an attempt to gather material for this.

In his book, Hofstadter also talks about [Exercices de style](https://en.wikipedia.org/wiki/Exercises_in_Style), written by Raymond Queneau, in which the same story is told in many different styles. It turns out that this book inspired [Exercises in Programming Style](https://github.com/crista/exercises-in-programming-style) where Cristina Videira Lopes implements the same task in the same programming language, Python, using different styles.

I decided that using the same task specifications for my own project might turn out to be useful. See below.

How to contribute
-----------------
If you are interested in contributing an implementation, please provide a Pull Request that introduces a new directory, with a appropriate name, containing a single implementation.

The implementation should be runnable with minimum efforts. Make sure to include instructions for executing the code.

If the implementation requires libraries or other additional files, please include them as well, license permitting.

The task
--------
We are implementing a basic word counter. More specifically, given a text file as input, we want the top 25 most frequent words.

The output
----------
A sample text file (Pride and Prejudice, by Jane Austen, as made available by the [Project Gutenberg](http://www.gutenberg.org/ebooks/42671)) is provided at the root of the repository. For sake of simplicity, it has already been simplified and normalized, so that all punctuation marks have been replaced with blank spaces, and all remaining words are in lower case. Also, stop words have been removed.

Here a possible output, based on the provided sample file. However, implementations should use whichever display makes most sense to the implementor.
```
mr: 782
elizabeth: 634
very: 488
darcy: 418
such: 395
mrs: 342
much: 329
bennet: 324
more: 322
bingley: 307
one: 303
jane: 294
miss: 283
know: 238
before: 230
herself: 227
well: 226
though: 226
never: 221
sister: 218
soon: 218
think: 211
now: 211
time: 204
good: 203
wickham: 194
```

License
-------
This project is released under the quite permissive MIT license. Please refer to the [license file](LICENSE). By contributing to this project, you agree to release your code under the same license. Please ensure that any libraries and other extra files you include are compatible with this license.
