(ns advent.day3-test
  (:require  [clojure.test :refer :all]
             [advent.day3 :refer :all]))

(deftest test-valid-passphrase
  (testing "positive cases"
    (is (valid-passphrase? "aa bb cc dd ee"))
    (is (valid-passphrase? "aa bb cc dd aaa")))
  (testing "negative cases"
    (is (not (valid-passphrase? "aa bb cc dd aa"))))
  (testing "boundary conditions"
    (is (not (valid-passphrase? "")))
    (is (not (valid-passphrase? nil)))))

(deftest test-num-valid-passphrases
  (testing "positive cases"
    (let [phrases "aa bb cc dd ee\naa bb cc dd aa\naa bb cc dd aaa\n"]
      (is (= 2 (num-valid-passphrases phrases)))))
  (testing "boundary conditions"
    (is (= nil (num-valid-passphrases nil)))
    (is (= nil (num-valid-passphrases "")))
    (is (= nil (num-valid-passphrases "        ")))))
