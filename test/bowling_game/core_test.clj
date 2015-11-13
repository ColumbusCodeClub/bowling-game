(ns bowling-game.core-test
  (:require [midje.sweet :refer :all]
            [bowling-game.core :refer :all]))

(facts "about scoring a game of bowling"
  (fact "a game of gutter balls has a score of 0"
    (score-game (repeat 20 0)) => 0 )
  (fact "a game of 1-pin balls has a score of 20"
    (score-game (repeat 1)) => 20 )
  (fact "a game with a spare gets one bonus roll"
    (score-game (concat [5 5 3] (repeat 17 0))) => 16 )
  (fact "a game with a strike gets two bonus rolls"
    (score-game (concat [10 1 1] (repeat 17 0))) => 14 )
  (fact "a perfect game has a score of 300"
    (score-game (repeat 10)) => 300)
  (fact "Scores Uncle Bob's example"
    (score-game [1 4 4 5 6 4 5 5 10 0 1 7 3 6 4 10 2 8 6]) => 133)
  )
;; [5 5 3] [3 0] [0 0]
;; [5 5] [3 0] [0 0]
