(ns browser.contrapunto-5
  (:require [browser.lib :as lib]))

(def phi-form [3 5 3 5 5 3 5 5])

(def range* (partial lib/range* phi-form))

(def parts
  {:insectos-1 [(range* 0 7)]
   :insectos-2 [(range* 1 5)]
   :insectos-3 [(range* 5 3)]
   :humedad-1 [(range* 0 6)]
   :humedad-2 [(range* 1 3)]
   :humedad-3 [(range* 6 1)]
   :estrellas-1 [(range* 0 8)]
   :estrellas-2 [(range* 4 4)]
   :estrellas-3 [(range* 3 2)]
   :estrellas-4 [(range* 2 1)
                 (range* 6 1)]
   :arboles [(range* 0 3)]
   :arboles-2 [(range* 5 3)]
   :aves [(range* 1 2)]})
