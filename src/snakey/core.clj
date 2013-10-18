(ns snakey.core
  (:gen-class))


(defrecord Rect [x y width height])

(defn rect [x y] 
  (Rect. x y 10 10))

(defn debug-rect [{:keys [x y width height]}]
  (str "Rect {x=" x ";y=" y ";width=" width ";height=" height ";}"))

(defn debug-snakey [[direction body]]
  [(str "Snakey is travelling '" direction "'")
   (map debug-rect body)])

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
  (push-new-head
     direction
     (pop-tail-end body)))






(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
