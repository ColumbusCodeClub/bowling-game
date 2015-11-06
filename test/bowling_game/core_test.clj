(ns bowling-game.core-test
  (:require [midje.sweet :refer :all]
            [bowling-game.core :refer :all]))

(facts "about scoring a game of bowling"
  (fact "a game of gutter balls has a score of 0"
    (score-game (repeat 20 0)) => 0 )
  (fact "a game of 1-pin balls has a score of 20"
    (score-game (repeat 20 1)) => 20 )
  (fact "a game with a spare gets one bonus roll"
    (score-game (concat [5 5 3] (repeat 17 0))) => 16 ))
