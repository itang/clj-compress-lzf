# clj-compress-lzf

A Clojure library designed to compress data well, that part is up to you.

## Install

local install

## Usage

    (compress from to)
    (decompress from to)

## Example

    (ns clj-compress-lzf.core-test
      (:require [clojure.test :refer :all]
                [clj-compress-lzf.core :refer :all]))

    (def message "hello,world")

    (def input-file "./target/hello.txt")
    (def compress-file "./target/hello.lzf")
    (def decompress-file "./target/hello.de.txt")

    (deftest compress-test
      (testing "compress"
        (spit input-file message)
        (is (= message
               (do (compress input-file compress-file)
                   (decompress compress-file decompress-file)
                   (slurp decompress-file))))))

## License

Copyright © 2013 itang

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
