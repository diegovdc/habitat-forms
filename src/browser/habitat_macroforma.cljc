(ns browser.habitat-macroforma
  (:require [browser.lib :as lib]))

(def grid [10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,3,10,8,5,8,8,5,8,3,10,8,5,8,8,5,8,3])

(def total-units (apply + grid))

(def parts
  (lib/make-parts
   grid
   {:amanecer [["Amanecer" 0 19]]
    :Día [["Día" 21 17]]
    :anochecer [[""  38 8 "Hay un fuego"]]
    "Travesía: llamas - Luz - Polinización - mundo subatómico - Hábitat" [["Travesía: llamas - Luz - Polinización - mundo subatómico - Hábitat" 38 16]]
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

(def time-characters
  (lib/make-parts
   grid
   {:time-characters [["Oscuridad-humedad" 0 8 "Tiempo geológico" {:class "time-character"
                                                   :style {:background-color "#23252788"}}]
                      ["Transiciones lumínicas" 8 4 "Tiempo geológico"
                       {:class "time-character"
                        :style {:background "linear-gradient(180deg, rgba(131,58,180,0.3) 0%, rgba(253,29,29,0.3) 50%, rgba(252,176,69,0.3) 100%)"}}]
                      ["Coro del amanecer" 12 8 "Tiempo de las especies"
                       {:class "time-character"
                        :style {:background "radial-gradient(circle, rgba(69,252,154,0.373284347918855) 11%, rgba(252,176,69,0.49933476808692223) 42%, rgba(253,29,94,0.5861695019804797) 59%, rgba(131,58,180,0.6617997540813201) 76%, rgba(253,29,94,0.2164216028208158) 96%, rgba(252,176,69,0.4405112386751575) 100%)"}}]
                      ["Polinizadores" 20 6 "Tiempo de las especies"
                       {:class "time-character"
                        :style {:background "radial-gradient(circle, rgba(251,252,69,0.373284347918855) 0%, rgba(248,250,123,1) 49%, rgba(243,247,196,1) 75%, rgba(252,176,69,0.49933476808692223) 89%, rgba(252,176,69,0.4405112386751575) 80%)"}}]
                      ["Escucha de aves" 26 9 "Tiempo geológico y de las especies: Amplio, espaciado, multiples puntos de escucha, escucha no humana, echos, reverberaciones, sonido en el espacio"
                       {:class "time-character"
                        :style {:background "radial-gradient(circle, rgba(34,193,195,0.4) 0%, rgba(253,187,45,0.5) 100%)"}}]
                      ["Transiciones lumínicas" 35 5 "Tiempo atmosférico y gelógico"
                       {:class "time-character"
                        :style {:background "linear-gradient(0deg, rgba(131,58,180,0.3) 0%, rgba(253,29,29,0.3) 50%, rgba(252,176,69,0.3) 100%)"
                                }}]
                      ["Lo humano" 40 6 "Tiempo de las especies: psicológico, misterio, oscuridad"
                       {:class "time-character"
                        :style {:background "#ff6f2a78"}}]]}))
(comment (-> parts keys count))
