(ns dojo.core-test
  (:require [clojure.test :refer :all]
            [dojo.core :refer :all]))

(deftest fizz?-test
  (testing "success"
    (is (= (fizz? 3) true)))
  (testing "fail fizz"
    (is (= (fizz? 13) false))))

(deftest buzz?-test
  (testing "success"
    (is (= (buzz? 5) true)))
  (testing "fail fizz"
    (is (= (buzz? 13) false))))

(deftest fizzbuzz-test
  (testing "fizzbuzz fizz"
    (with-redefs-fn {#'fizz? (fn [arg] true), #'buzz? (fn [arg] false)}
      #(is (= (fizzbuzz 15) "fizz"))))
  (testing "fizzbuzz buzz"
    (with-redefs-fn {#'fizz? (fn [arg] false), #'buzz? (fn [arg] true)}
      #(is (= (fizzbuzz 15) "buzz"))))
  (testing "fizzbuzz number"
    (with-redefs-fn {#'fizz? (fn [arg] false), #'buzz? (fn [arg] false)}
      #(is (= (fizzbuzz 15) 15))))
  (testing "fizzbuzz fizzbuzz"
    (with-redefs-fn {#'fizz? (fn [arg] true), #'buzz? (fn [arg] true)}
      #(is (= (fizzbuzz 15) "fizzbuzz")))))

