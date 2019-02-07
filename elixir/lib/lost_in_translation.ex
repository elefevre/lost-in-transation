defmodule LostInTranslation do

  def main(args \\ [])

  def main([filename]), do: display_top_words_in_file(filename)

  def main(_), do: :error


  def display_top_words_in_file(filename) do
    read_lines(filename)
    |> Enum.map(fn line -> count_words_in_line(line) end)
    |> aggregate_line_counts()
    |> get_top_words()
    |> Enum.reduce("", fn {word, count}, text -> text <> "#{word}: #{count}\n" end)
    |> IO.puts()
  end

  def read_lines(filename) do
    File.stream!(filename, [:utf8, :read_ahead,])
  end

  def count_words_in_line(text) do
    text
    |> String.split(" ")
    |> Enum.reduce(%{}, &count_word/2)
  end

  def aggregate_line_counts(line_counts, total_count \\ %{})

  def aggregate_line_counts([line_count | rest], total_count) do
    aggregate_line_counts(rest, Map.merge(total_count, line_count, fn _, a, b -> a + b end))
  end

  def aggregate_line_counts([], total_count), do: total_count

  def get_top_words(count) do
    count
    |> Enum.sort_by(fn {_, occurences} -> occurences end, &>=/2)
    |> IO.inspect()
    |> Enum.take(25)
#    |> Keyword.new()
  end

  defp count_word("", count), do: count

  defp count_word(word, count) when is_map(count) do
    count
    |> Map.put(word, case Map.get(count, word) do
        nil -> 1
        value -> value + 1
      end)
  end
end
