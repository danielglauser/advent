(ns advent.day4
  (:require [clojure.string :as str]))

(defn valid-passphrase?
  "Given a string containing all lowercase words a valid passphrase is one where
  none of the words repeat."
  [phrase]
  (if-not (str/blank? phrase)
    (let [phrase-seq (str/split phrase #" ")
          n-words (count phrase-seq)
          n-unique-words (count (set phrase-seq))]
      (= n-words n-unique-words))
    false))

(defn num-valid-passphrases
  "Given a string containing a newline delimited list of passphrases
  returns the number of valid passphrases."
  [phrases-str]
  (when-not (str/blank? phrases-str)
    (let [phrases (str/split phrases-str #"\n")
          phrase-statuses (map valid-passphrase? phrases)]
      (count (filter true? phrase-statuses)))))
