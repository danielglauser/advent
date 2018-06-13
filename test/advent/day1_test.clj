(ns advent.day1-test
  (:require [advent.day1 :refer :all]
            [clojure.test :refer :all]))

(deftest test-partition-over
  (testing "positive cases"
    (is (= '((1 2) (2 3) (3 4)) (partition-over '(1 2 3 4))))
    (is (= '((1 2) (2 3)) (partition-over '(1 2 3)))))
  (testing "boundary cases"
    (is (= nil (partition-over '(1))))
    (is (= nil (partition-over '())))
    (is (= nil (partition-over nil)))))

(deftest test-sum-digits-that-match
  (testing "positive cases"
    (is (= 3 (sum-digits-that-match 1122)))
    (is (= 4 (sum-digits-that-match 1111)))
    (is (= 9 (sum-digits-that-match 91212129))))
  (testing "negative cases"
    (is (= 0 (sum-digits-that-match 1234))))
  (testing "boundary cases"
    (is (= 0 (sum-digits-that-match 0)))
    (is (= nil (sum-digits-that-match nil)))
    (is (= nil (sum-digits-that-match "NaN")))))
