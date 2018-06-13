(ns advent.day2-test
  (:require  [clojure.test :refer :all]
             [advent.day2 :refer :all]))

(deftest test-checksum
  (testing "positive cases"
    (is (= 8 (checksum [5 1 9 5])))
    (is (= 4 (checksum [7 5 3])))
    (is (= 6 (checksum [2 4 6 8]))))
  (testing "boundary cases"
    (is (= nil (checksum nil)))
    (is (= nil (checksum [])))))

(deftest test-ckeck-spreadsheet
  (testing "positive cases"
    (let [sheet "5\t1\t9\t5\n7\t5\t3\n2\t4\t6\t8"]
      (is (= 18 (check-spreadsheet sheet)))))
  (testing "boundary cases"
    (is (= nil (check-spreadsheet nil)))
    (is (= nil (check-spreadsheet "")))
    (is (= nil (check-spreadsheet "       ")))))
