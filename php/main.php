<?php

main($argv);

function main($argv)
{
    $words = count_words($argv[1]);
    arsort($words);

    $i = 0;
    foreach ($words as $word => $count) {
        printf("%s: %d\n", $word, $count);
        $i++;
        if ($i > 25) {
            break;
        }
    }
}

function count_words($filename)
{
    $all_words = array();

    $file_lines = file($filename);
    foreach ($file_lines as $line) {
        $words = preg_split('/\s+/', $line);
        foreach ($words as $word) {
            if ($word == "") {
                continue;
            }
            $all_words[$word]++;
        }
    }

    return $all_words;
}
