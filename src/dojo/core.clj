(ns dojo.core
  (:gen-class))

(defn fizz? [n]
  (= 0 (mod n 3)))

(defn buzz? [n]
  (= 0 (mod n 5)))

(defn fizzbuzz [n]
  (cond (and (fizz? n) (buzz? n)) "fizzbuzz"
        (fizz? n) "fizz"
        (buzz? n) "buzz"
        :else n))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def numero (Integer. (first args)))
  (println (fizzbuzz numero)))
