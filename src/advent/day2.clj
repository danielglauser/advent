(ns advent.day2
  (:require [clojure.string :as str]))

(defn checksum
  "Takes a seq of numbers and returns the difference between the highest
  and lowest values."
  [row]
  (when (seq row)
    (let [minimum (apply min row)
          maximum (apply max row)]
      (- maximum minimum))))

(defn check-spreadsheet
  "Given a text based spreadsheet where each field is tab delimited and
  each row is newline delimited this function determines the checksum
  of the entire spreadsheet."
  [sheet]
  (when-not (str/blank? sheet)
    (let [rows (str/split sheet #"\n")
          checksums (for [row rows]
                      (-> row
                          (str/split #"\t")
                          (as-> rw (map #(Long/parseLong %) rw))
                          checksum))]
      (apply + checksums))))
