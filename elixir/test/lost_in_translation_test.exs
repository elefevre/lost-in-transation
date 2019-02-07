defmodule LostInTranslationTest do
  use ExUnit.Case

  @tested_module LostInTranslation
  @test_file "../pride-and-prejudice.txt"

  describe "#{@tested_module}.read_lines" do
    test "should return a stream of every line in the file" do
      stream = LostInTranslation.read_lines(@test_file)

      assert %{__struct__: File.Stream} = stream
      assert %{line_or_bytes: :line} = stream
      assert %{modes: [{:encoding, :utf8}, {:read_ahead, 65536}, :binary]} = stream
    end
  end

  describe "#{@tested_module}.count_words_in_line" do
    test "should return a Map containing the number of occurence of each word" do
      count = LostInTranslation.count_words_in_line("foo bar bar")

      assert %{"foo" => 1, "bar" => 2} = count
    end

    test "should ignore multiple spaces" do
      count = LostInTranslation.count_words_in_line("foo  foo")

      assert %{"foo" => 2} = count
      assert 1 = map_size(count)
    end
  end

  describe "#{@tested_module}.aggregate_line_counts" do
    test "should sum count of each word" do
      count = LostInTranslation.aggregate_line_counts([%{"foo" => 1}, %{"foo" => 4, "bar" => 3}])

      assert %{"foo" => 5, "bar" => 3} = count
      assert 2 = map_size(count)
    end

    test "should return an empty Map when given an empty List" do
      count = LostInTranslation.aggregate_line_counts([])

      assert %{} = count
      assert 0 = map_size(count)
    end
  end

  describe "#{@tested_module}.get_top_words" do
    test "should return the top 25 word" do
      count = 1..100
      |> Enum.shuffle()
      |> Enum.reduce(%{}, fn index, acc -> Map.put(acc, "foo#{index}", index) end)
      top_entries = LostInTranslation.get_top_words(count)

      assert 25 = length(top_entries)
      assert Enum.map(100..76, fn index -> "foo#{index}" end) === Keyword.keys(top_entries)
      assert Enum.map(100..76, &(&1)) === Keyword.values(top_entries)
    end
  end
end
