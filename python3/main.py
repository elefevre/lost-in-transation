#!/usr/bin/env python

from collections import Counter

import sys

with open(sys.argv[1]) as f:
    counters = Counter(f.read().split())

words = [(word, counter) for word, counter in counters.items()]
words = sorted(words, key=lambda x: x[1], reverse=True)

for w in words[:26]:
    print("%s: %d" % (w[0], w[1]))
