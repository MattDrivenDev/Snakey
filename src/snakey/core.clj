(ns snakey.core
  (:gen-class))

(defrecord Rect [x y width height])

(defn rect [x y]
  (Rect. x y 10 10))

(defn reduce-bools [coll]
  (loop [coll coll
         acc  true]
    (if (= coll [])
      acc
      (recur (rest coll) (if (first coll) acc false)))))

(defn rects-intersect? [a b]
  (reduce-bools [(>= (+ (:x a) (:width a)) (:x b))
                 (>= (+ (:x b) (:width b)) (:x a))
                 (>= (+ (:y a) (:height a)) (:y b))
                 (>= (+ (:y b) (:height b)) (:y a))]))

(defn create-new-head [direction {:keys [x y]}]
  (case direction
    :up    (rect x (- y 10))
    :down  (rect x (+ y 10))
    :left  (rect (- x 10) y)
    :right (rect (+ x 10) y)))

(defn push-new-head [direction body]
  (cons (create-new-head direction (first body)) body))

(defn pop-tail-end [body]
  (pop body))

(defn move-forwards [[direction body]]
  (push-new-head direction
    (pop-tail-end body)))






(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
