(def lower-bound (atom nil))
(def upper-bound (atom nil))
(def current-guess (atom nil))

(defn start [n m]
  (reset! lower-bound n)
  (reset! upper-bound m)
  (reset! current-guess (quot (+ n m) 2))
  "Я готов...")

(defn guess-my-number []
  @current-guess)

(defn smaller []
  (swap! upper-bound (fn [_] (dec @current-guess)))
  (swap! current-guess (fn [_] (quot (+ @lower-bound @upper-bound) 2)))
  @current-guess)

(defn bigger []
  (swap! lower-bound (fn [_] (inc @current-guess)))
  (swap! current-guess (fn [_] (quot (+ @lower-bound @upper-bound) 2)))
  @current-guess)
