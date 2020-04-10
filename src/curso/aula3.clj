(ns curso.aula3)


; PREDICATE - Funcoes com interrogacao
(defn aplica-desconto?
  [valor-bruto]
  (when (> valor-bruto 100)
    true))

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

;(println (valor-descontado 1000))
;(println (valor-descontado 100))


;HIGH ORDER FUNCTIONS

(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se deve aplicar desconto"
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado mais-caro-que-100? 1000))
(println (valor-descontado mais-caro-que-100? 100))

;FUNCAO ANONIMA / LAMBDA
(println "Funcao anonima")
(println (valor-descontado (fn [v] (> v 100)) 1000))
(println (valor-descontado (fn [v] (> v 100)) 100))

(println (valor-descontado #(> %1 100) 1000))
(println (valor-descontado #(> %1 100) 100))

(println (valor-descontado #(> % 100) 1000))
(println (valor-descontado #(> % 100) 100))

; Atribuiçao de funçao anonima a um simbolo.
(def mais-caro-que-100? #(> %1 100))


