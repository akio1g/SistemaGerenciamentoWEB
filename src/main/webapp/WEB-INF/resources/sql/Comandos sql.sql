USE DistribuidoraAMZ
EXEC sp_adicionar_cliente --x,x,x,x,x,x,x,x,x,x Usada para adicionar um cliente
Exec sp_lista_clientes -- Usada para listar os Clientes
EXEC sp_buscar_cliente_por_nome --x-- (x = nome do cliente) Usada para buscar o cliente pelo nome
EXEC sp_buscar_cliente_por_id --x--(x = id_cliente)Usada para buscar um cliente pelo id
EXEC sp_buscar_endereco_por_id_cliente --x-- (x = id_cliente) Usada para buscar o endereco do cliente pelo id_cliente
EXEC sp_update_cliente --y,x,x,x,x,x,x,x,x,x (y = id de referencia) -- Usada para realizar o update do cliente limitando a colunas validas
EXEC sp_excluir_cliente --x-- (x = id_cliente) Usada para excluir um cliente

EXEC sp_adicionar_fornecedores --x,x,x,x,x,x,x,x,x,x Usada para adicionar um fornecedor
EXEC sp_lista_fornecedores -- Usada para listar os Fornecedores
EXEC sp_buscar_fornecedor_por_nome
EXEC sp_buscar_fornecedor_por_id 
EXEC sp_buscar_endereco_por_id_fornecedor 
EXEC sp_update_fornecedor  --y,x,x,x,x,x,x,x,x,x (y = id de referencia) -- Usada para realizar o update do fornecedor limitando a colunas validas
EXEC sp_excluir_fornecedor_por_id --x-- (x = id_fornecedor) Usada para excluir um fornecedor

EXEC sp_adicionar_produto --x,x,x,x Usada para adicionar um novo produto
EXEC sp_listar_produto
EXEC sp_listar_produto_por_categoria 1 --x (x = id_categoria) Usada pra listar os produtos por categoria
EXEC sp_pesquisar_produto_por_nome
EXEC sp_editar_produto --x,x,x,x,y (y = id_produto) Usada para editar um produto pelo id
EXEC sp_excluir_produto_por_id --x (X = id_produto) Usada para excluir um produto pelo id

EXEC sp_listar_categorias -- Usada para listar categorias

EXEC sp_adicionar_usuario --x,x,x,x,x Usada pra adicionar um usuario
EXEC sp_listar_usuarios -- Usada para listar os usuarios
EXEC sp_excluir_usuario_por_id --x Usada para excluir o usuario pelo id
EXEC sp_editar_usuario --x,x,x Usada para editar o usuario
EXEC sp_verificar_duplicidade --x,x Usada para verificar duplicidade
EXEC sp_pesquisar_Usuario_Por_Nome --x Usada para pesquisar usuario pelo nome
EXEC sp_pesquisar_Usuario_Por_Id --X Usada para pesquisar pro id