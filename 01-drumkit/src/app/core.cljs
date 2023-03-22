(ns app.core)

(defn play-sound [e]
  (let [key-code (.-keyCode e)
        key-element (.querySelector js/document (str ".key[data-key=\"" key-code "\"]"))
        audio-element (.querySelector js/document (str "audio[data-key=\"" key-code "\"]"))]
    (when-not (nil? audio-element)
      (set! (.-currentTime audio-element) 0)
      (.play audio-element)
      (.classList/add key-element "playing")
      (.play audio-element))))


(defn remove-transition [e]
  (this-as this
    (if (= (.-propertyName e) "transform")
      (.classList/remove this "playing"))))

(let [keys (.querySelectorAll js/document ".key")]
  (doseq [key keys]
    (.addEventListener key "transitionend" remove-transition)))

(.addEventListener js/window "keydown" play-sound)

