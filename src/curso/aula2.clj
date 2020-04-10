(ns curso.aula2)

(println "Olá, Mundo!")
(println "Soma de 2 + 3 = " (+ 2 3))

"Comentário"
; Comentário

; definindo um simbolo
(def total-de-produtos (+ 13 4))
(println "Total" total-de-produtos)

; definindo um simbolo com valor de um array
(def estoque ["Mochila", "Camiseta"])
(println "Estoque:" estoque)
(println "Primeiro Item:" (estoque 0))
(println "Numero de itens:" (count estoque))

(def estoque (conj estoque "Cadeira"))
(println "Estoque:" estoque)

"Definindo funções"
; Definindo Funções
(defn ola-mundo
  []
  (println "-----------")
  (println "Olá, Mundo!")
  (println "-----------"))

(ola-mundo)


(defn console-log
  [arg]
  (println arg))

(console-log "Olá")


(defn aplicar-desconto [valor-bruto]
  (* valor-bruto 0.9))

(println (aplicar-desconto 50))

(defn valor-descontado
  "Retorna o valor descontado que é de 90% do valor bruto"
  [valor-bruto]
  (* valor-bruto 0.9))

(println (valor-descontado 100))


(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (* valor-bruto (- 1 0.1)))

(println (valor-descontado 100))


"Definindo simbolos locais com let"

(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [desconto (/ 10 100)]
    (println "Calculando desconto de" desconto)
    (* valor-bruto (- 1 desconto))))

(println (valor-descontado 100))


(println (class 90.0)) "Double"
(println (class 90N)) "BigInt"
(println (class 90M)) "BigDecimal"


(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto         (* valor-bruto taxa-de-desconto)]
    (println "Calculando desconto de" desconto)
    (- valor-bruto desconto)))

(println "-------------------")
(println (valor-descontado 100))

(if (> 10 12)
  (println "Verdadeiro")
  (println "Falso"))


(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior do que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto  (/ 10 100)
          desconto          (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))
    valor-bruto))

(println "-------------------")
(println (valor-descontado 100))

(println "-------------------")
(println (valor-descontado 150))