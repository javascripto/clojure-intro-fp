(ns curso.aula4)

(def precos [30 700 1000])

(println "Preços:" precos)

(println (precos 0))
(println (get precos 0))

;index out of bounds exception
;(println (precos 17))
(println "valor padrão nil" (get precos 17))
(println "valor padrão 0" (get precos 17 0))

; adicionar item em novo vetor
(println (conj precos 30))

; increment, decrement
(println (+ 5 1))
(println (inc 5))
(println (dec 5))

;Atualizado valor em novo array
(println (update precos 0 inc))

(defn soma-1 [valor] (+ valor 1))
(println (update precos 0 soma-1))                          ; [31, 700, 1000]

; map, filter, reduce
(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior do que 100"
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (map valor-descontado precos))

(println (filter aplica-desconto? precos))

; range, even?, odd?
(println (range 10))
(println (filter (fn [x] (< x 5)) (range 10)))              ; filtrando valores menores que 5
(println "Filtrando valores pares:" (filter even? (range 10)))  ; numeros pares
(println "Filtrando valores ímpares:" (filter odd? (range 10))) ; numeros impares

; compondo funçoes com filter e map
(println "map após filter:" (map valor-descontado (filter aplica-desconto? precos)))

; reduce
(defn sum
  [x, y]
  (println "somando" x "com" y)
  (+ x y))

(println (reduce + precos))
(println (reduce sum precos))
(println (reduce (fn [x, y] (+ x y)) precos))
(println (reduce (fn [acc, cur] (+ acc cur)) precos))

(println (reduce sum [1]))                                  ; reduce com unico elemento
(println (reduce sum 0 [1]))                                ; reduce com unico elemento e valor inicial
(println (reduce sum 0 []))                                 ; reduce sem elementos mas com valor inicial

(println (some even? (range 10)))
