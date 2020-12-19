(ns browser.main
  (:require [browser.colors :as colors]
            [browser.contrapunto-5 :as c5]
            [goog.string :refer [format]]
            [reagent.dom :as dom]
            [browser.difraccion-interferencia :as difraccion-interferencia]
            [browser.habitat-macroforma :as habitat]))

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

(def get-color (memoize (fn [name*] (rand-nth colors/hex-colors))))

(defn instrument-line [human-duration period [name* moments]]
  [:div {:class "instrument-line"
         :key name*}
   (map (fn [{:keys [start-at dur quien notas] :as event}]
          (let [times (get-human-time-data human-duration period event)
                title (format "%s %s (%s - %s, dur: %s)"
                              (name name*)
                              quien
                              (times :time/start-at)
                              (times :time/end-at)
                              (times :time/dur))]
            [:div {:key (str name start-at dur)
                   :title title
                   :class "instrument-event"
                   :style {:width (as-% dur period)
                           :left (as-% start-at period)
                           :background-color (str (get-color quien) "88")}}
             [:div {:class "event-main"}
              [:p {:style {:font-size 17}} (name name*) " " #_quien]
              [:div {:class "event-notes"} [:p notas]]
              [:span {:style {:font-size 18}} (format "%s-%s" (times :time/start-at) (times :time/end-at))]]]))
        moments)])

(defn form
  "`period` determines the full length of the form"
  [human-duration parts period]
  [:div
   (->> parts
        #_(sort-by (comp #(apply + (map :dur %)) second))
        #_reverse
        (map (partial instrument-line human-duration period)))])

(defn app []
  (form
   (* 60 60)
   habitat/parts
   habitat/total-units))

(defn start []
  (dom/render [app] (. js/document (getElementById "app"))))

(defn stop []
  (println "Restarting"))

(comment
  (reset! app-state))

(defn ^:export init [opts]
  (start))
