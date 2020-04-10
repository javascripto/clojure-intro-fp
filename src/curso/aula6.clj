(ns curso.aula6)

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
  (println "valor" valor)
  15)

(defn imprime-e-15 [valor]
  (println "valor" (class valor))                           ; clojure.lang.MapEntry
  15)

; Desestruturando chave e valor do MapEntry
(defn imprime-e-15 [[chave valor]]
  (println "Chave ->" chave "| Valor ->" valor )
  15)

(println (map imprime-e-15 pedido))

(defn preco-do-produto [[_ valor]]
  (*(:quantidade valor) (:preco valor)))

(println (map preco-do-produto pedido))

(defn total-do-pedido
  [pedido]
  (reduce + (map preco-do-produto pedido)))

(println "Preço total do pedido:" (total-do-pedido pedido))

; THREAD LAST
(defn total-do-pedido
  [pedido]
  (->> pedido
      (map preco-do-produto ,,,)
      (reduce + ,,,)))

(println "Preço total do pedido:" (total-do-pedido pedido))

;---------------------------------------------------------------
(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto ,,,)
       (reduce + ,,,)))

(println "Preço total do pedido:" (total-do-pedido pedido))

;---------------------------------------------------------------

(defn gratuito?
  [produto]
  (<= (get produto :preco 0) 0))

(def chaveiro {:quantidade 1})

(println (gratuito? chaveiro))

(println (first { :produto {:valor 20} :dois {:valor 0}}))
(println (second { :produto {:valor 20} :dois {:valor 0}}))

(println (not true))

; Composição
(defn pago [x] (not (gratuito? x)))
(def pago (comp not gratuito?))                             ; composiçao definido como simbolo e nao funçao


(println (pago {:preco 10}))
(println (pago {:preco 0}))

