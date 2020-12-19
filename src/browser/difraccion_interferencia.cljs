(ns browser.difraccion-interferencia
  (:require [browser.lib :as lib]))
;; p=377 g=233 submos: 21)21/55
(def grid [5,13,16,5,13,16,5,16,5,13,16,5,13,8,13,16,5,13,16,5,16,5,13,16,5,13,8,13,16,5,13,16,5,16])
(def total-units (apply + grid))

(def A "A")
(def D "D")
(def N "N")
(def X "X")

#_(def parts
    (lib/make-parts
     grid
     {:texturada [[X 3 4] [X 6 8 "<->claroscuro"]]
      :claroscuro [[X 0 3] [X 7 8 "<->texturada"]]
      :brillante [[X 1 4]]
      :difraccion [[X 4 6] [X 5 6]]
      :interferencias [[A 6 5 "solo"]]
      }))


#_(def parts
  (lib/make-parts
   grid
   {:diego [["claroscuro" 0 3]
            ["texturada/claroscuro" 6 3]
            ["interferencia" 9 1]
            ["difracción" 12 3  "al fondo"]
            #_["x" 13 1 ]
            ["refracción" 15 3 "interferencia"]
            ["interferencia" 18 2]
            ["difracción" 21 4 "solo"]
            ["interferencia" 26 3 "seguir a Nefi"]
            ["fusión" 32 2]]
    :nefi [["brillante" 1 2 "desde oscuro"]
           #_["brillante" 3 1 "a difraccón"]
           ["difracción" 5 3]
           #_["x" 13 1 ]
           ["texturada/claroscuro" 8 1]
           ["interferencia" 9 1]
           ["difracción" 11 4 "solo"]
           ["refracción" 17 4]
           ["refracción" 24 3]
            ["interferencia" 28 1]
           ["vibrante" 29 2 "solo - a brillante"]
           ["brillante" 31 1 "solo"]
           ["fusión" 32 2]]
    :aaron [["difracción" 2 1 "fadein"]
            ["difracción" 3 4 ]
            ["texturada/claroscuro" 7 1]
            ["interferencia" 8 4 ]
            ["refracción" 15 3 "interferencia"]
            ["interferencia" 18 3]
            ["refracción" 24 3 "interferencia"]
            ["interferencia" 27 2 "seguir a Nefi"]
            ["fusión" 33 1]]}))


(def parts
  (lib/make-parts
   grid
   {:insectos [["Insectos" 0 7]]
    :y [["áves" 2 3]]
    :z []}))
