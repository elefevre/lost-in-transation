#!/usr/bin/env bash
cat $1 | tr -s ' ' '\n' | sort | uniq -c | sort | head -n 25 | awk '{ print $2, $1 }'
