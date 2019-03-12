use std::collections::HashMap;
use std::fs::File;
use std::io::BufReader;
use std::io::prelude::*;
use std::env;

fn main() -> std::io::Result<()> {
    let args: Vec<_> = env::args().collect();
    if args.len() != 2 {
        eprintln!("usage: {} filename", args[0]);
        return Result::Err(std::io::Error::new(std::io::ErrorKind::Other, ""))
    }

    let file = File::open(&args[1])?;
    let buf_reader = BufReader::new(file);
    let lines = buf_reader.lines().map(|l| l.unwrap());

    let mut freqs = HashMap::new();

    for l in lines {
        let words = l.split_whitespace();
        for w in words {
            let val = match freqs.get(&w.to_string()) {
                Some(c) => c+1,
                None => 1,
            };
            freqs.insert(w.to_string(), val);
        }
    }
    let mut counts: Vec<_> = freqs.iter().collect();
    counts.sort_by(|a, b| b.1.cmp(a.1)); // compare by count value
    for (w, c) in counts.iter().take(25) {
        println!("{}:{}", w, c);
    }
    Ok(())
}
