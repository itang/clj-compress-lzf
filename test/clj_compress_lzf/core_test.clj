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
