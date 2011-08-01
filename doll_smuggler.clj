;(use 'clojure.contrib.trace)

;;(def doll {:weight "4" :value "150"})
(defstruct doll :weight :value :name)
(def shipment[
	(struct doll 9 150 "map") 
	(struct doll 13 35 "compass") 
	(struct doll 153 200 "water") 
	(struct doll 50 160 "sandwich")
	(struct doll 15 60 "glucose")
	(struct doll 68 45 "tin")
	(struct doll 27 60 "banana")
	(struct doll 39 40 "apple")
	(struct doll 23 30 "cheese")
	(struct doll 52 10 "beer")
	(struct doll 11 70 "suntan")
	(struct doll 32 30 "camera")
	(struct doll 24 15 "t-shirt")
	(struct doll 48 10 "trousers")
	(struct doll 73 40 "umbrella")
	(struct doll 42 70 "waterproof trowsers")
	(struct doll 43 75 "waterproof overclothes")
	(struct doll 22 80 "note-case")
	(struct doll 7 20 "sunglasses")
	(struct doll 18 12 "towel")
	(struct doll 4 50 "socks")
	(struct doll 30 10 "boots")
])
(declare memoize-calculate-optimal)

(defn calculate-optimal [index mWeight]
	;(println "calling calculate optimal for" index mWeight)
	;if invalid object index, or weight is zero
	(if (or (< index 0) (= mWeight 0)) 
		[0[]]
		
		;;get the doll at this index, get references to its weight and values
		(let [{itemWeight :weight itemValue :value} (get shipment index)]
			;(println itemWeight " and " itemValue)
			;if the doll won't fit
			(if (> itemWeight mWeight)
				;skip to the next doll
				(memoize-calculate-optimal (dec index) mWeight)
				; else try see if this doll is optimal - first bind variables to some results using let
				(let [[valueNotPacking setNotPacking] (memoize-calculate-optimal (dec index) mWeight)
				[valuePacking setPacking] (memoize-calculate-optimal (dec index) (- mWeight itemWeight) ) ]
					;see what is optimal - packing the doll or not packing the doll
					(if (> (+ valuePacking itemValue) valueNotPacking )
						;its a keeper - add value to the total, add item to the list
						[(+ valuePacking itemValue) (conj setPacking index)]
						;its not a keeper - use value and list from not packing
						[ valueNotPacking setNotPacking ]
					)
				)
			)
		)
		
	)		
)
(def memoize-calculate-optimal(memoize calculate-optimal))


(defn use-known-data[]
	(println "using weight" (def max-weight 400))
	(println "using shipment data" shipment)
	(let[[totalValue packedItems](calculate-optimal (dec (count shipment)) max-weight) ]
		(println "packed " (count packedItems) " items including indexes " packedItems " with total value " totalValue)
		(doseq [doll packedItems] (println (shipment doll)))
			
	)
)
(defn use-custom-data [] (println "poo"))

(defn setup []
	(println "do you want to enter your own dataset? (y or n)")
	(def custom-data (read-line))(flush)
	(if(= custom-data "y")
		(use-custom-data )
		(use-known-data )
	)
		
	;(println "Enter a max weight.")(flush)
	;(def max-weight (Integer. (read-line)))
	;(println "Weight entered" max-weight)(flush)
	;(println "shipment:" shipment)
	;(println (calculate-optimal (dec (count shipment)) max-weight))

)
(setup)