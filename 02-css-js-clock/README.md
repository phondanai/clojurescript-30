# 02-JSCSSCLOCK

## Dev mode - this will sum up figwheel.
`clj -M:dev`

## Build
`clj -M -m cljs.main --optimizations advanced -c app.core`


## What I learn
### You can access (or set) nested property via `..` syntax

from JS
`secondHand.style.transform = "rotate(90deg)";`
to CLJS
`(set! (.. -style -transform secondHand) "rotate(90deg)")`
