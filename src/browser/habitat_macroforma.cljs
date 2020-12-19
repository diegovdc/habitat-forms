(ns browser.habitat-macroforma
  (:require [browser.lib :as lib]))

(def grid [10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,8,5,8,3])
(count grid)
(def total-units (apply + grid))

(def parts
  (lib/make-parts
   grid
   {:amanecer [["x" 0 18]]
    :atardecer [["y" 18 21]]
    :anochecer [["z"  39 16]]
    :polinizadores [["polinizadores" 24 5]
                    ["polinizadores" 43 5]]
    :insectos [["insectos" 19 3]]
    :partifluc [["particulas y fluctuaciones" 46 3]]}))
