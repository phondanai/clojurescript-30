(ns app.core)

(defn setDate []
  (let [now (js/Date.)
        secondHand (.querySelector js/document ".second-hand")
        minuteHand(.querySelector js/document ".min-hand")
        hourHand(.querySelector js/document ".hour-hand")
        seconds (.getSeconds now)
        minutes (.getMinutes now)
        hours (.getHours now)
        seconds-degrees (+ (* (/ seconds 60) 360) 90)
        minutes-degrees(+ (* (/ minutes 60) 360) 90)
        hours-degrees (+ (* (/ hours 12) 360) 90)]
    (set! (.. secondHand -style -transform) (str "rotate(" seconds-degrees "deg)"))
    (set! (.. minuteHand -style -transform) (str "rotate(" minutes-degrees "deg)"))
    (set! (.. hourHand -style -transform) (str "rotate(" hours-degrees "deg)"))))


(js/setInterval setDate 1000)

(setDate)
