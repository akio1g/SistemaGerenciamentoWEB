USE DistribuidoraAMZ
EXEC EXEC sp_adicionar_cliente --x,x,x,x,x,x,x,x,x,x Usada para adicionar um cliente
Exec sp_lista_clientes -- Usada para listar os Clientes
EXEC sp_lista_fornecedores -- Usada para listar os Fornecedores
EXEC sp_buscar_cliente_por_nome --x-- (x = nome do cliente) Usada para buscar o cliente pelo nome
EXEC sp_buscar_cliente_por_id --x--(x = id_cliente)Usada para buscar um cliente pelo id
EXEC sp_buscar_endereco_por_id_cliente --x-- (x = id_cliente) Usada para buscar o endereco do cliente pelo id_cliente
EXEC sp_update_cliente --y,x,x,x,x,x,x,x,x,x (y = id de referencia) -- Usada para realizar o update do cliente limitando a colunas validas
EXEC sp_excluir_cliente --x-- (x = id_cliente) Usada para excluir um cliente