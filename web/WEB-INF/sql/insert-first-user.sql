/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sanderson
 * Created: 01/11/2017
 */
INSERT INTO cidade (id, estado, nome) 
	VALUES (1, 'PARAIBA', 'Patos');

INSERT INTO endereco (id, bairro, cep, complemento, logradouro, numero, pontoreferencia, cidade_id) 
	VALUES (1, 'Belo Horizonte', '58704-310', '', 'Rua Luiz Jose', 624, 'Em frente ao Alzanir', 1)

INSERT INTO pessoa (id, cpf, datanascimento, email, nome, sexo, telefone, endereco_id) 
	VALUES (1, '096.583.734-37', '2017-11-01', 'sandersonsoaresm@gmail.com', 'Sanderson Soares Marinho da Costa', 'MASCULINO', '999679134', 1);

INSERT INTO grupo (id, titulo)
	VALUES (1, 'Administradores');

INSERT INTO grupo_permissoes (id, permissoes)
	VALUES (1, 'ACESSA_SISTEMA');





