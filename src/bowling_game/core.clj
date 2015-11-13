(ns bowling-game.core)

(defn spare? [rolls]
  (= (+ (first rolls) (second rolls)) 10))

(defn strike? [rolls]
  (= (first rolls) 10))

(defn- rolls-per-frame [rolls]
  (if (or (strike? rolls) (spare? rolls)) 3 2))

(defn- rolls-to-advance-per-frame [rolls]
  (if (strike? rolls) 1 2))

(defn to-frames [rolls]
  (lazy-seq (cons (take (rolls-per-frame rolls) rolls)
                  (to-frames (drop (rolls-to-advance-per-frame rolls) rolls)))))

(defn- frame-score [frame-rolls]
  (reduce + frame-rolls))

(defn score-game [rolls]
  (reduce + (map frame-score (take 10 (to-frames rolls)))))
