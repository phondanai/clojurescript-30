(ns app.core)


;-- filter
;-- filter the list of inventors for those who were born in the 1500's--
(let [inventors (js->clj js/inventors)]
  (->> inventors
   (filter (fn [x] 
            (and 
              (< (get x "year") 1600) 
              (> (get x "year") 1499))))
   (clj->js)
   (.table js/console)))


;-- map
;-- array of the inventors first and last names
(let [inventors (js->clj js/inventors)]
  (->> inventors
   (map (fn [x] 
            (str
              (get x "first")
              " "
              (get x "last"))))
   (clj->js)
   (.table js/console)))


;-- sort
;-- sort the inventors by birthdate, oldest to youngest
(let [inventors (js->clj js/inventors)]
  (.table js/console (clj->js
  (sort-by (fn [x] 
             (get x "year")) inventors))))


;-- reduce
;-- how many years did all the inventors live all together
(let [inventors (js->clj js/inventors)]
  (.log js/console 
    (reduce (fn [x y] 
             (+ 
               (get x "passed") (get x "year")
               (get y "passed") (get y "year"))) 
            inventors)))


;-- sort the inventors by years lived
(let [inventors (js->clj js/inventors)]
  (.table js/console (clj->js
  (reverse (sort-by (fn [x] 
             (- (get x "passed") (get x "year"))) inventors)))))


;-- sort the people alphabetically by last name
(let [people (js->clj js/people)]
  (.log js/console (clj->js
  (sort-by (fn [x] 
             (let [lname (last (clojure.string/split x #", "))]
               lname)) people ))))


;-- reduce exercise
;-- sum up the instances of each of data
(let [data (js->clj js/data)]
  (->> data
    (frequencies)
    (clj->js)
    (.log js/console)))
