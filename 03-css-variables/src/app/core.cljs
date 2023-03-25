(ns app.core)

(def inputs (.querySelectorAll js/document ".controls input"))


(defn handleUpdate []
  (this-as this
    (let [suffix (-> this
                     (.-dataset)
                     (.-sizing))]
      (.setProperty
        (.-style (.-documentElement js/document))
        (str "--" (.-name this))
        (str (.-value this) suffix)))))


(doseq [input inputs]
  (.addEventListener input "change" handleUpdate)
  (.addEventListener input "mousemove" handleUpdate))

