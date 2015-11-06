(ns bowling-game.core)

(defn- to-frames [rolls]
  (lazy-seq (cons (take 2 rolls) (to-frames (drop 2 rolls)))))

(defn- frame-score [rolls]
  (reduce + rolls))

(defn score-game [rolls]
  (reduce + (map frame-score (take 10 (to-frames rolls)))))
