(ns browser.lib)

(defn range* [grid start len]
  (let [max (apply + grid)
        end (+ start len)
        durs (subvec grid start end)
        dur (apply + durs)
        start-at (apply + (subvec grid 0 start))
        end-at (->> (subvec grid end) (apply +) (- max))]
    {:start-at start-at :end-at end-at :dur dur :durs durs}))

(defn make-parts [grid simple-parts]
  (into {}
        (map (fn [[k v]]
               [k
                (map (fn [[quien start length notas]]
                       (merge {:quien quien :notas notas}
                              (range* grid start length))) v)])
             simple-parts)))
