(ns clj-compress-lzf.core
  (:import [com.ning.compress.lzf LZFInputStream LZFOutputStream])
  (:require [clojure.java.io :as io]))

(defn compress [from to]
  (with-open [in (io/input-stream from)
              out (LZFOutputStream. (io/output-stream to))]
    (io/copy in out)))

(defn decompress [from to]
  (with-open [in (LZFInputStream. (io/input-stream from))
              out (io/output-stream to)]
    (io/copy in out)))
