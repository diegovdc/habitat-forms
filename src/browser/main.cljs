(ns browser.main
  (:require [browser.colors :as colors]
            [browser.contrapunto-5 :as c5]
            [browser.difraccion-interferencia :as difraccion-interferencia]
            [browser.habitat-macroforma :as habitat]
            [goog.string :refer [format]]
            goog.string.format
            [reagent.core :as r]
            [reagent.dom :as dom]))

;; MOS p=34, g=21
(def phi-form [3 5 3 5 5 3 5 5])

(do
  (defn as-minutes [seconds]
    (str (quot seconds 60) ":" (let [s (int (mod seconds 60))]
                                 (if (< s 10) (str "0" s) s))))
  (as-minutes 70))

(defn scale [duration parts]
  (let [max (apply + phi-form)
        scale-fn #(as-minutes (* duration (/ % max)))]
    (map (fn [[k v]]
           (let [{:keys [start-at dur end-at]} v]
             [k (-> v
                    (assoc :time/start-at (scale-fn start-at))
                    (assoc :time/dur (scale-fn dur))
                    (assoc :time/end-at (scale-fn end-at)))]))
         parts)))

(defn get-human-time-data [total-duration period {:keys [start-at dur end-at]
                                                  :as event}]
  (let [scale-fn #(as-minutes (* total-duration (/ % period)))]
    (-> event
        (assoc :time/start-at (scale-fn start-at))
        (assoc :time/dur (scale-fn dur))
        (assoc :time/end-at (scale-fn end-at)))))

(defn as-% [dur period] (str (* 100 (/ dur period)) "%"))

(defonce get-color (memoize (fn [name*] (rand-nth colors/hex-colors))))

(defn instrument-line [human-duration period [name* moments]]
  [:div {:class "instrument-line"
         :key name*}
   (map (fn [{:keys [start-at dur que notas] :as event}]
          (let [times (get-human-time-data human-duration period event)
                title (format "%s %s %s (%s - %s, dur: %s)"
                              (name name*)
                              (if (= (name name*) que) "" que)
                              (or notas "")
                              (times :time/start-at)
                              (times :time/end-at)
                              (times :time/dur))]
            [:div {:key (str name start-at dur)
                   :title title
                   :class "instrument-event"
                   :style {:width (as-% dur period)
                           :left (as-% start-at period)
                           :background-color (str (get-color name*) "88")}}
             [:div {:class "event-main"}
              [:p {:style {:font-size 17 :line-break "anywhere"}} que]
              [:div {:class "event-notes"} [:p notas]]
              #_[:span {:style {:font-size 18}} (format "%s-%s" (times :time/start-at) (times :time/end-at))]]]))
        moments)])

(defn form
  "`period` determines the full length of the form"
  [human-duration parts period]
  [:div
   (->> parts
        #_(sort-by (comp #(apply + (map :dur %)) second))
        #_reverse
        (map (partial instrument-line human-duration period)))])


(defn grid-durations [duration grid]
  (let [total (apply + grid)
        grid-seq-as-% (reduce #(conj %1 (+ (last %1) (/ %2 total))) [] grid)
        grid-seq-as-minutes (map (comp as-minutes #(* duration %)) grid-seq-as-%)]
    {:as-% (cons 0 grid-seq-as-%)
     :grid-in-% (cons 0 (map #(/ % total) grid))
     :as-minutes (cons "0:00" grid-seq-as-minutes)}))

(defn grid [duration grid]
  (let [width 1600]
    [:svg {:stroke "#000"
           :stroke-width "0.03em"
           :fill "none"
           :viewBox (format "0 0 %s 800" width)
           :width "100%"
           :xmlns "http://www.w3.org/2000/svg"}
     (let [{:keys [as-minutes as-%]} (grid-durations duration grid)]
       (map-indexed
        (fn [i v]
          (let [v* (str (* width v))
                text-y (if (even? i) 7 14)
                text-transform (cond (zero? i) nil
                                     (= i (- (count as-%) 1)) "translate(-11.5 0)"
                                     (< i 9) "translate(-5 -1)"
                                     (>= i 9) "translate(-10 -1)"
                                     )
                font-size (if (or (zero? i) (= i (- (count as-%) 1)))
                            "0.3em" "0.6em")]
            [:g
             [:text {:x v*
                     :y text-y
                     :transform text-transform
                     :stroke-width 0.03
                     :fill "#000"
                     :font-size font-size
                     :font-family "monospace"}
              (str (nth as-minutes i) "(" i ")")]
             [:line {:x1 v*
                     :x2 v*
                     :y1 text-y
                     :y2 "100%"
                     :stroke-dasharray "3,1"}]]))
        as-%))]))

(defonce state (r/atom {::scale 1}))
(defn app []
  [:div {:style {:width (-> @state ::scale (* 100) (str "vw"))}}
   [:div {:style {:position "fixed"
                  :z-index 3
                  :bottom 0
                  :right 0}}
    [:label "Score size"
     [:input {:type "number"
              :value (@state ::scale)
              :step 0.25
              :on-change #(do
                            (js/console.log "scale" %)
                            (swap! state assoc ::scale (-> % .-target .-value js/Number )))}]]]
   [:div {:style {:position "absolute"
                  :top 0
                  :left 0
                  :width "inherit"
                  :height "100%"}}
    (grid (* 60 60) habitat/grid)]
   [:div {:style {:padding-top 40}}
    (form
     (* 60 60)
     habitat/parts
     habitat/total-units)]])



(defn start []
  (dom/render [app] (. js/document (getElementById "app"))))

(defn stop []
  (println "Restarting"))

(comment
  (reset! app-state))

(defn ^:export init [opts]
  (start))
