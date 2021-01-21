(ns browser.habitat-macroforma
  (:require [browser.lib :as lib]))

(def grid [10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,8,5,8,3])

(def total-units (apply + grid))

(def parts
  (lib/make-parts
   grid
   {:amanecer [["Amanecer" 0 19]]
    :Día [["Día" 21 17]]
    :anochecer [["Anochecer"  39 16]]
    "Travesía: llamas - Luz - Polinización - mundo subatómico - Hábitat" [["Travesía: llamas - Luz - Polinización - mundo subatómico - Hábitat" 42 13]]
    :atractores [["" 22 3 "toro"]
                 ["" 31 5 "toro, extraño"]
                 ["" 40 6 "punto fijo, cíclo límite"]]
    :tiempos []
    "Espacio de las áves" [#_["" 7 0 "Coro de la mañana"]
                           ["" 12 5 "coro de la mañana" ]
                           ["" 24 3 "movimiento-vuelo-danza" ]
                           ["" 32 5 "escucha de aves" ]
                           ["" 20 2 "alimentación" ]
                           ["" 29 9 "habitar" ]]
    :humedad [["" 0 9 "humedad"]]
    :insectos [["" 7 4 "descomponer"]
               ["" 17 2 "habitar"]
               ["" 22 3 "polinizar"]
               ["" 24 3 "danzar"]
               ["" 28 4 "flotar"]
               ["" 10 2 "túneles (mov. subterraneo)"]
               ["" 38 5 "túneles (mov. subterraneo)"]
               ["" 35 2 "mov. ágil"]
               ["" 45 1 "acechar"]
               ["" 46 2 "atacar"]
               ["" 47 1 "defender"]
               ["" 50 4 "volar"]]
    :polinizadores [["" 22 6 "polinizadores"]
                    ["" 43 4 "polinizadores"]]
    "Partículas y fluctuaciones" [["" 16 6 "Partículas y fluctuaciones"]
                                  ["" 47 5 "Partículas y fluctuaciones"]]
    "Flucturaciones cuánticas" [["" 1 5 "Fluctuaciones cuánticas"]
                                ["" 32 9 "Fluctuaciones cuánticas"]]
    "Nucleones p+, n" [["" 39 5 "Nucleones p+, n"]]
    :campos [["" 3 7 "campos"]
             ["" 26 4 "campos"]]
    :orbitales [["" 6 3 "orbitales"]
                ["" 11 3 "orbitales"]
                ["" 21 3 "orbitales"]]
    :electrones [["" 4 3 "electrones"]
                 ["" 47 2 "electrones"]]
    "Interacciones cuánticas" [["" 12 5 "interaccines cuánticas (fotones/color)"]]
    }))

(comment (-> parts keys count))
