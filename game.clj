(def lower (atom 1))
(def upper (atom 100))

(defn start [n m]
  (reset! lower n)
  (reset! upper m)
  "Я готов...")

(defn guess-my-number []
  (quot (+ @lower @upper) 2))

(defn smaller []
  (swap! upper (fn [_] (dec (guess-my-number))))
  (guess-my-number))

(defn bigger []
  (swap! lower (fn [_] (inc (guess-my-number))))
  (guess-my-number))
