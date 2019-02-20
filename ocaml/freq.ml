open Base
open Stdio

let build_counts filename =
  let ic = In_channel.create filename in
  let counts = (Map.empty (module String)) in
  In_channel.fold_lines ic ~init:counts ~f:(fun counts line ->
    let words = String.split ~on:' ' line in
    List.fold words ~init:counts ~f:(fun counts word ->
      let count =
        match Map.find counts word with
        | None -> 0
        | Some x -> x
      in
      Map.set counts ~key:word ~data:(count + 1)
    )
  )

let () =
  let filename = Sys.argv.(1) in
  build_counts (filename)
  |> Map.fold ~f:(fun ~key:k ~data:v l -> (k,v)::l) ~init:[]
  |> List.sort ~compare:(fun (_,x) (_,y) -> Int.descending x y)
  |> (fun l -> List.take l 25)
  |> List.iter ~f:(fun (word,count) -> printf "%s: %3d\n" word count)
