(ns advent.day1)

(defn partition-over
  "Given a seq of elements (1 2 3 4) produces a lazy-seq of the form
  ((1 2) (2 3) (3 4))."
  [xs]
  (when (>= (count xs) 2)
    (lazy-seq
     (cons (list (first xs) (second xs))
           (partition-over (rest xs))))))

(defn sum-digits-that-match
  "Returns the sum of all matching digits. For example, 1122 returns 3 because
  the one's match and the two's match so 1+2=3."
  [num]
  (when (number? num)
    (let [digits (map #(Character/digit % 10) (str num))
          wrap-tuple (list (first digits) (last digits))
          all-tuples (conj (partition-over digits) wrap-tuple)]
      (reduce (fn [acc tuple]
                (if (= 1 (count (set tuple)))
                  (+ acc (first tuple))
                  acc))
              0
              all-tuples))))
