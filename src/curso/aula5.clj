(ns curso.aula5)

; Hashmaps

; Vírgula é opcional
(def estoque { "Mochila" 10, "Camiseta" 5 })

(def estoque {
              "Mochila" 10
              "Camiseta" 5 })

; keywords como chave no lugar de strings
(def estoque {:mochila 10
              :camiseta 5})
(println estoque)

(println "Temos" (count estoque) "elementos")
(println "Chaves:" (keys estoque))
(println "Valores:" (vals estoque))

; adicionar valor (em novo mapa)
(println estoque)
(println (assoc estoque :cadeira 3))

; redefinindo coleçao com novo valor adicionado
(println estoque)
(def estoque (assoc estoque :cadeira 3))

; update valor aplicando função
(println estoque)
(println (update estoque :mochila inc))

; removendo elementos (em nova colecao)
(println (dissoc estoque :mochila))


(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(println "\n\n\n\n\n\n")
(println pedido)

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))
(println pedido)

; obtendo valores de chaves em mapas
(println (pedido :camiseta))                                ; symbol como funcão
(println (:camiseta pedido))                                ; invertendo keyword e symbol
(println (get pedido :camiseta))                            ; usando get
(println (get pedido :item-nao-existente {}))               ; usando get e valor padrão
(println (:item-nao-existente pedido {}))                   ; keyword como funçao e valor padrao


; update-in
(println "Quantidade de mochilas no pedido:" (:quantidade (:mochila pedido)))
(println pedido)
(println (update-in pedido [:mochila :quantidade] inc))     ; updade em mapa com niveis de profundidade

;
(println pedido)

; Prefix
(println "Mochilas:" (:quantidade (:mochila pedido)))

; THREADING FIRST
(println (-> pedido
    :mochila
    :quantidade))

(-> pedido
    :mochila
    :quantidade
    println)

