(ns browser.habitat-macroforma
  (:require [browser.lib :as lib]))

(def grid [10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,8,5,8,3])

(def total-units (apply + grid))

(def parts
  (lib/make-parts
   grid
   {:amanecer [["Amanecer" 0 19]]
    :Día [["Día" 21 17]]
    :anochecer [["Anochecer"  38 16]]
    "Travesía: llamas - Luz - Polinización - mundo subatómico - Hábitat" [["Travesía: llamas - Luz - Polinización - mundo subatómico - Hábitat" 45 10]]
    :atractores [["" 28 5 "toro"]
                 #_["" 31 5 "toro, extraño"]
                 ["" 39 6 "punto fijo, cíclo límite"]]
    :tiempos []
    "Espacio de las áves" [#_["" 7 0 "Coro de la mañana"]
                           ["" 12 5 "coro de la mañana" ]
                           #_["" 22 2 "alimentación"]
                           ["" 19 1 "escucha" ]
                           ["" 20 3 "mov. vuelo" ]
                           ["" 28 5 "escucha de aves" ]
                           #_["" 29 9 "habitar" ]]
    :humedad [["" 0 9 "humedad"]]
    :insectos [["" 7 4 "descomponer"]
               ["" 17 2 "habitar"]
               ["" 22 3 "polinizar"]
               ["" 23 3 "danzar"]
               ["" 21 4 "flotar"]
               ["" 10 2 "túneles (mov. subterraneo)"]
               #_["" 38 5 "túneles (mov. subterraneo)"]
               ["" 35 2 "mov. ágil"]
               ["" 37 1 "acechar"]
               ["" 38 2 "atacar"]
               #_["" 39 1 "defender"]
               ["" 53 2 "volar"]]
    :polinizadores [["" 21 6 "polinizadores"]
                    ["" 48 5 "polinizadores"]]
    "Partículas y fluctuaciones" [["" 16 6 "Partículas y fluctuaciones"]
                                  #_["" 47 5 "Partículas y fluctuaciones"]]
    "Flucturaciones cuánticas" [["" 1 5 "Fluctuaciones cuánticas"]
                                #_["" 32 9 "Fluctuaciones cuánticas"]]
    "Nucleones p+, n" [["" 41 8 "Nucleones p+, n"]]
    :campos [["" 3 7 "campos"]
             ["" 30 6 "campos"]]
    :orbitales [["" 6 3 "orbitales"]
                #_["" 11 3 "orbitales"]
                ["" 21 3 "orbitales"]]
    :electrones [["" 4 3 "electrones"]
                 ["" 47 2 "electrones"]]
    "Interacciones cuánticas" [["" 11 6 "interacciones cuánticas (fotones/color)"]]
    }))

(comment (-> parts keys count))
