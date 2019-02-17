use std::collections::HashMap;
use std::fs::File;
use std::io::BufReader;
use std::io::prelude::*;

fn main() -> std::io::Result<()> {
    let file = File::open("../../pride-and-prejudice.txt")?;
    let buf_reader = BufReader::new(file);
    let lines = buf_reader.lines().map(|l| l.unwrap());

    let mut freqs = HashMap::new();

    for l in lines {
        let words = l.split_whitespace();
        for w in words {
            println!("{}", w);
            let val = match freqs.get(&w.to_string()) {
                Some(c) => c+1,
                None => 1,
            };
            freqs.insert(w.to_string(), val);
        }
    }
    println!("{:?}", freqs);
    Ok(())
}
